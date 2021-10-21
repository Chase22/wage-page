package org.wagepage.wagepage.infrastructure.extensions

import arrow.core.Either

fun <A, B> Either<A, B>.onRight(action: (value: B) -> Unit) =
    this.map {
        action(it)
        it
    }
