package com.xinaiz.evilkotlin.nullability

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Invoke block only if all it's arguments are not null
 */
@Evilness(HowEvil.LITTLE_EVIL)
inline fun <R, A> ifNotNull(a: A?, block: (A) -> R): R? =
  if (a != null) {
    block(a)
  } else null

@Evilness(HowEvil.LITTLE_EVIL)
inline fun <R, A, B> ifNotNull(a: A?, b: B?, block: (A, B) -> R): R? =
  if (a != null && b != null) {
    block(a, b)
  } else null

@Evilness(HowEvil.LITTLE_EVIL)
inline fun <R, A, B, C> ifNotNull(a: A?, b: B?, c: C?, block: (A, B, C) -> R): R? =
  if (a != null && b != null && c != null) {
    block(a, b, c)
  } else null

@Evilness(HowEvil.LITTLE_EVIL)
inline fun <R, A, B, C, D> ifNotNull(a: A?, b: B?, c: C?, d: D?, block: (A, B, C, D) -> R): R? =
  if (a != null && b != null && c != null && d != null) {
    block(a, b, c, d)
  } else null

@Evilness(HowEvil.LITTLE_EVIL)
inline fun <R, A, B, C, D, E> ifNotNull(a: A?, b: B?, c: C?, d: D?, e: E?, block: (A, B, C, D, E) -> R): R? =
  if (a != null && b != null && c != null && d != null && e != null) {
    block(a, b, c, d, e)
  } else null