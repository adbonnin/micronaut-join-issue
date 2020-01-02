package issue.repositories

import io.micronaut.test.annotation.MicronautTest
import issue.domain.User
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class UserRepositorySpec extends Specification {

    @Inject
    UserRepository userRepository

    def "should find an user by login"() {
        given:
        def user = userRepository.save(new User(login: login))

        expect:
        user.id

        when:
        def foundUser = userRepository.findByLogin(login).orElse(null)

        then:
        foundUser.login == login

        where:
        login = 'emanon'
    }
}
