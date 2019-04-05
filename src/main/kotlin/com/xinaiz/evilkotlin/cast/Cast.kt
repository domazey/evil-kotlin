package com.xinaiz.evilkotlin.cast

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Cast object to desired type without added parenthesis layer.
 * This might cause programmer's IDE to lose some insight into the cast
 */

@Evilness(HowEvil.PRETTY_EVIL)
inline fun <reified T> Any.cast() = this as T
