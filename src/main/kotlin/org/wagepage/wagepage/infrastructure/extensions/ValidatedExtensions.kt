package org.wagepage.wagepage.infrastructure.extensions

import arrow.core.*

fun <E, A> Validated.Companion.validate(
    error: E,
    value: A,
    predicate: (A) -> Boolean
): Validated<E, A> =
    when {
        predicate.invoke(value) -> Valid(value)
        else -> Invalid(error)
    }

/**
 * @return None if predicate returns true otherwise returns error
 */
fun <E, A> Option.Companion.validate(
    error: E,
    value: A,
    predicate: (A) -> Boolean
): Option<E> =
    when {
        predicate.invoke(value) -> None
        else -> Some(error)
    }

fun <E, A, M> Option.Companion.validate(
    onError: (M) -> E,
    value: A,
    predicate: (A) -> Option<M>
): Option<E> =
    predicate.invoke(value)
        .map { onError(it) }
        .orElse { None }

fun <E, A> Validated.Companion.checkAll(
    value: A,
    vararg predicates: (A) -> Option<E>
): ValidatedNel<E, A> =
    checkAllList(value, * predicates.map { it.andThen { it.toList() } }.toTypedArray())

fun <E, A> Validated.Companion.checkAllList(
    value: A,
    vararg predicates: (A) -> List<E>
): ValidatedNel<E, A> =
    NonEmptyList.fromList(predicates.flatMap { it(value) })
        .map { Invalid(it) }
        .getOrElse { Valid(value) }

fun <T> Set<T>.toOptionOnEmpty(): Option<Set<T>> = if (this.isEmpty()) None else Some(this)

fun <E, A> List<ValidatedNel<E, A>>.collectAllNel(): ValidatedNel<E, List<A>> =
    this.fold(Valid(emptyList())) { acc: ValidatedNel<E, List<A>>, next ->
        when {
            next is Valid && acc is Valid -> acc.map { it + next.value }
            next is Valid && acc is Invalid -> acc
            next is Invalid && acc is Valid -> next
            next is Invalid && acc is Invalid -> acc.mapLeft { errors: NonEmptyList<E> -> errors + next.value }
            else -> acc
        }
    }

fun <E, A> List<Validated<E, A>>.collectAll(): ValidatedNel<E, List<A>> =
    this.map { it.toValidatedNel() }
        .collectAllNel()

fun <E, A, B> Validated<E, A>.flatMap(that: (A) -> Validated<E, B>): Validated<E, B> =
    this.fold(::Invalid, that)

fun <E, A> Validated<E, Validated<E, A>>.flatten(): Validated<E, A> =
    this.fold(::Invalid) { it }
