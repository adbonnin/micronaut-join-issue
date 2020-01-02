package issue.domain

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@MappedEntity
class User {

    @Id
    @GeneratedValue
    Long id

    String login

    @Relation(Relation.Kind.ONE_TO_MANY)
    Set<Authority> authorities = new HashSet<>()
}
