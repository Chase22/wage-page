package org.wagepage.wagepage.domain

import arrow.core.Validated
import com.rewe.digital.servicefeecustomization.domain.ValidationError
import org.wagepage.wagepage.infrastructure.extensions.validate
import java.util.*

data class Amount(
    val inCents: UInt,
    val currency: Currency
) {
    enum class Error : ValidationError {
        CURRENCY_NOT_SUPPORTED
    }

    companion object {
        @JvmStatic
        fun create(inCents: UInt, currency: Currency): Validated<Error, Amount> =
            Validated.validate(Error.CURRENCY_NOT_SUPPORTED, Amount(inCents, currency)) {
                supportedCurrencies.contains(currency)
            }
    }
}

val supportedCurrencies = setOf(Currency.getInstance("EUR"))