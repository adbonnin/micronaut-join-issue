package issue.repositories

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import issue.domain.Authority

@JdbcRepository(dialect = Dialect.H2)
interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Optional<Authority> findByName12345(String name)
}