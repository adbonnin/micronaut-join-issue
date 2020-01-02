package issue.domain

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@MappedEntity
class Authority {

    @NotEmpty
    @Size(max = 50)
    @Id
    String name12345
}
