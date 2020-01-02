package issue.repositories

import io.micronaut.test.annotation.MicronautTest
import issue.domain.Authority
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AuthorityRepositorySpec extends Specification {

    @Inject
    AuthorityRepository authorityRepository

    void "should save and find an authorities"() {
        given:
        def authority = new Authority(name12345: name)

        when:
        def savedAuthority = authorityRepository.save(authority)
        def foundAuthority = authorityRepository.findByName12345(savedAuthority.name12345).orElse(null)

        then:
        foundAuthority.name12345 == name

        where:
        name = 'ROLE_ADMIN'
    }
}
