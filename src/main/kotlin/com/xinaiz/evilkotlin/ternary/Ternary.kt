package com.xinaiz.evilkotlin.ternary

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Simulate ternary operator from java
 * condition then A ?: B
 */
@Evilness(HowEvil.PRETTY_EVIL)
infix fun <T> Boolean.then(param: T): T? = if (this) param else null