package com.xinaiz.evilkotlin.expressions

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Use when all values of enum should be handled separately inside "when" expression.
 * Do not use "else" in such expression or it doesn't make any sense.
 * If you add enum value to enum class, it will raise compilation
 * error instead of warning, so you won't forget to handle it.
 */
@Evilness(HowEvil.WHY_IS_THIS_IN_THIS_LIBRARY)
val <T> T.exhaustive: T
  get() = this