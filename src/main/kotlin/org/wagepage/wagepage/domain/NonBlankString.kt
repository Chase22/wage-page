package org.wagepage.wagepage.domain

import arrow.core.Validated
import com.rewe.digital.servicefeecustomization.domain.ValidationError
import dev.ahmedmourad.nocopy.annotations.NoCopy
import org.wagepage.wagepage.infrastructure.extensions.validate

@NoCopy
data class NonBlankString private constructor(val value: String) {

    companion object {
        @JvmStatic
        fun create(value: String): Validated<Error, NonBlankString> =
            Validated.validate(Error.VALUE_IS_BLANK, NonBlankString(value)) { value.isNotBlank() }
    }

    enum class Error: ValidationError {
        VALUE_IS_BLANK
    }
}
