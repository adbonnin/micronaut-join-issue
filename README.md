# micronaut-join-issue

Create application:
```
mn create-app issue --lang groovy --features application,http-client,http-server,jdbc-hikari,liquibase,logback,spock
```

Stacktrace:
```
16:42:01.629 [Test worker] DEBUG io.micronaut.data.query - Executing SQL Insert: INSERT INTO `user` (`login`) VALUES (?)
16:42:01.647 [Test worker] DEBUG io.micronaut.data.query - Executing Query: SELECT user_.`id`,user_.`login`,user_authorities_.`name12345` AS authorities_name12345 FROM `user` user_ INNER JOIN user_authority user_authorities_user_authority_ ON user_.name12345=user_authorities_user_authority_.user_id  INNER JOIN authority user_authorities_ ON user_authorities_user_authority_.authority_id=user_authorities_.name12345 WHERE (user_.`login` = ?)

Error executing SQL Query: Colonne "USER_.NAME12345" non trouvée
Column "USER_.NAME12345" not found; SQL statement:
SELECT user_.`id`,user_.`login`,user_authorities_.`name12345` AS authorities_name12345 FROM `user` user_ INNER JOIN user_authority user_authorities_user_authority_ ON user_.name12345=user_authorities_user_authority_.user_id  INNER JOIN authority user_authorities_ ON user_authorities_user_authority_.authority_id=user_authorities_.name12345 WHERE (user_.`login` = ?) [42122-199]
io.micronaut.data.exceptions.DataAccessException: Error executing SQL Query: Colonne "USER_.NAME12345" non trouvée
Column "USER_.NAME12345" not found; SQL statement:
SELECT user_.`id`,user_.`login`,user_authorities_.`name12345` AS authorities_name12345 FROM `user` user_ INNER JOIN user_authority user_authorities_user_authority_ ON user_.name12345=user_authorities_user_authority_.user_id  INNER JOIN authority user_authorities_ ON user_authorities_user_authority_.authority_id=user_authorities_.name12345 WHERE (user_.`login` = ?) [42122-199]
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.lambda$findOne$2(DefaultJdbcRepositoryOperations.java:217)
	at io.micronaut.transaction.support.AbstractSynchronousTransactionManager.executeRead(AbstractSynchronousTransactionManager.java:157)
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.findOne(DefaultJdbcRepositoryOperations.java:174)
	at io.micronaut.data.runtime.intercept.DefaultFindOptionalInterceptor.intercept(DefaultFindOptionalInterceptor.java:47)
	at io.micronaut.data.runtime.intercept.DefaultFindOptionalInterceptor.intercept(DefaultFindOptionalInterceptor.java:34)
	at io.micronaut.data.intercept.DataIntroductionAdvice.intercept(DataIntroductionAdvice.java:79)
	at io.micronaut.aop.chain.MethodInterceptorChain.proceed(MethodInterceptorChain.java:69)
	at issue.repositories.UserRepositorySpec.should find an user by login(UserRepositorySpec.groovy:23)
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Colonne "USER_.NAME12345" non trouvée
Column "USER_.NAME12345" not found; SQL statement:
SELECT user_.`id`,user_.`login`,user_authorities_.`name12345` AS authorities_name12345 FROM `user` user_ INNER JOIN user_authority user_authorities_user_authority_ ON user_.name12345=user_authorities_user_authority_.user_id  INNER JOIN authority user_authorities_ ON user_authorities_user_authority_.authority_id=user_authorities_.name12345 WHERE (user_.`login` = ?) [42122-199]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:451)
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:427)
	at org.h2.message.DbException.get(DbException.java:205)
	at org.h2.message.DbException.get(DbException.java:181)
	at org.h2.expression.ExpressionColumn.getColumnException(ExpressionColumn.java:176)
	at org.h2.expression.ExpressionColumn.optimize(ExpressionColumn.java:158)
	at org.h2.expression.condition.Comparison.optimize(Comparison.java:205)
	at org.h2.expression.condition.ConditionAndOr.optimize(ConditionAndOr.java:134)
	at org.h2.expression.condition.ConditionAndOr.optimize(ConditionAndOr.java:134)
	at org.h2.command.dml.Select.prepare(Select.java:1248)
	at org.h2.command.Parser.prepareCommand(Parser.java:689)
	at org.h2.engine.Session.prepareLocal(Session.java:627)
	at org.h2.engine.Session.prepareCommand(Session.java:565)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1292)
	at org.h2.jdbc.JdbcPreparedStatement.<init>(JdbcPreparedStatement.java:77)
	at org.h2.jdbc.JdbcConnection.prepareStatement(JdbcConnection.java:349)
	at com.zaxxer.hikari.pool.ProxyConnection.prepareStatement(ProxyConnection.java:315)
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.prepareStatement(DefaultJdbcRepositoryOperations.java:766)
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.lambda$findOne$2(DefaultJdbcRepositoryOperations.java:176)
	... 7 more
```