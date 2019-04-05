package com.xinaiz.evilkotlin.casts

/**
 * Cast object to desired type without added parenthesis layer.
 * This might cause programmer's IDE to lose some insight into the cast
 */
inline fun <reified T> Any.cast() = this as T
