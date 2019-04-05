package com.xinaiz.evilkotlin.errorhandling

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default expression.
 * YOU LOSE:
 * 1. The cause what happened
 * 2. Dignity
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(block: () -> T, default: () -> T) = try {
  block()
} catch (ex: Throwable) {
  default()
}

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(block: () -> T, default: T) = tryOrDefault(block) { default }

/**
 * Try to access variable.
 * If something bad happens ¯\_(ツ)_/¯ return a default expression.
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(property: T, default: () -> T) = tryOrDefault({ property }, default)

/**
 * Try to access variable.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(property: T, default: T) = tryOrDefault(property) { default }