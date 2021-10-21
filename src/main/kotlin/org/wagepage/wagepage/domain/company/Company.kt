package org.wagepage.wagepage.domain.company

import dev.ahmedmourad.nocopy.annotations.NoCopy
import org.wagepage.wagepage.domain.Entity
import org.wagepage.wagepage.domain.Id
import org.wagepage.wagepage.domain.Name

@NoCopy
data class Company private constructor(
    override val id: Id,
    val name: Name,
    val city: String
    ) : Entity {
        companion object {
            @JvmStatic
            fun create(id: Id, name: Name, city: String) = Company(id, name, city)
        }
    }