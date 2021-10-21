package org.wagepage.wagepage.domain.wage

import dev.ahmedmourad.nocopy.annotations.NoCopy
import org.wagepage.wagepage.domain.Amount
import org.wagepage.wagepage.domain.Entity
import org.wagepage.wagepage.domain.Id
import java.time.LocalDate

@NoCopy
data class Wage private constructor(
    override val id: Id,
    val wage: Amount,
    val workHours: UInt,
    val paidVacation: UInt,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val jobId: Id
) : Entity {
    companion object {
        @JvmStatic
        fun create(
            id: Id,
            wage: Amount,
            workHours: UInt,
            paidVacation: UInt,
            startDate: LocalDate,
            endDate: LocalDate,
            jobId: Id
        ) = Wage(id, wage, workHours, paidVacation, startDate, endDate, jobId)
    }
}