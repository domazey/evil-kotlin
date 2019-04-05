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
inline fun <reified T> tryOrDefault(block: () -> T, default: () -> T) = try {
  block()
} catch (ex: Throwable) {
  default()
}

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 */
@Evilness(HowEvil.VERY_EVIL)
inline fun <reified T> tryOrDefault(block: () -> T, default: T) = tryOrDefault(block) { default }

/**
 * Try to execute block
 * Even worse than tryOrDefault. Accepts default value
 * Usage: { mightThrow() } default 42
 */
@Evilness(HowEvil.VERY_EVIL)
inline infix fun <reified T> (()->T).default(default: T) = tryOrDefault(this, default)

/**
 * Try to execute block
 * Even worse than tryOrDefault. Accepts default expression
 * Usage: { mightThrow() } default 42
 */
@Evilness(HowEvil.VERY_EVIL)
inline infix fun <reified T> (()->T).default(default: () -> T) = tryOrDefault(this, default)