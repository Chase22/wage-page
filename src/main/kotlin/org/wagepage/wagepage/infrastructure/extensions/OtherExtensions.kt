package org.wagepage.wagepage.infrastructure.extensions

import arrow.core.Option
import arrow.core.Validated
import arrow.core.ValidatedNel
import com.rewe.digital.servicefeecustomization.domain.ValidationError
import org.wagepage.wagepage.domain.Id
import java.util.*

fun <T> Optional<T>.option() = Option.fromNullable(this.orElseGet { null })

fun validateId(id: String): ValidatedNel<UuidFormatError, Id> {
    return try {
        Validated.Valid(Id.fromString(id)).toValidatedNel()
    } catch (e: IllegalArgumentException) {
        Validated.Invalid(UuidFormatError()).toValidatedNel()
    }
}

fun validateCurrency(currencyCode: String): ValidatedNel<InvalidCurrencyError, Currency> {
    return try {
        Validated.Valid(Currency.getInstance(currencyCode)).toValidatedNel()
    } catch (e: IllegalArgumentException) {
        Validated.Invalid(InvalidCurrencyError()).toValidatedNel()
    }
}

class InvalidCurrencyError : ValidationError

class UuidFormatError : ValidationError