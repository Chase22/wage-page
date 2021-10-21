package org.wagepage.wagepage.domain.job

import dev.ahmedmourad.nocopy.annotations.NoCopy
import org.wagepage.wagepage.domain.Entity
import org.wagepage.wagepage.domain.Id
import org.wagepage.wagepage.domain.NonBlankString
import java.time.LocalDate

@NoCopy
data class Job private constructor(
    override val id: Id,
    val title: NonBlankString,
    val start_date: LocalDate,
    val end_date: LocalDate?,
    val company_id: Id,
    val user_id: Id
) : Entity {
    companion object {
        @JvmStatic
        fun create(
            id: Id,
            title: NonBlankString,
            start_date: LocalDate,
            end_date: LocalDate?,
            company_id: Id,
            user_id: Id
        ) = Job(id, title, start_date, end_date, company_id, user_id)
    }
}