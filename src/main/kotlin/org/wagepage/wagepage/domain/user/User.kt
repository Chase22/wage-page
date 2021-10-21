package org.wagepage.wagepage.domain.user

import dev.ahmedmourad.nocopy.annotations.NoCopy
import org.wagepage.wagepage.domain.Entity
import org.wagepage.wagepage.domain.Id
import org.wagepage.wagepage.domain.Name
import org.wagepage.wagepage.domain.NonBlankString

@NoCopy
data class User private constructor(
    override val id: Id,
    val name: Name,
    val firstName: String,
    val lastName: String,
    val email: NonBlankString
) : Entity {
    private fun clone(
        id: Id = this.id,
        name: NonBlankString = this.name,
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        email: NonBlankString = this.email
    ): User = create(id, name, firstName, lastName, email)

    companion object {
        @JvmStatic
        fun create(id: Id, name: Name, firstName: String, lastName: String, email: NonBlankString) =
            User(id, name, firstName, lastName, email)
    }
}