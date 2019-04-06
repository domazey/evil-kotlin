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
 * Nullable default version of [tryOrDefault]
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefaultNullable(block: () -> T, default: T?): T? = try {
  block()
} catch (ex: Throwable) {
  default
}

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(block: () -> T, default: T) = tryOrDefault(block) { default }

/**
 * Try to execute block
 * Even worse than tryOrDefault. Accepts default value
 * Usage: { mightThrow() } onError 42
 */
@Evilness(HowEvil.VERY_EVIL)
infix fun <T> (() -> T).onError(default: T) = tryOrDefault(this, default)

/**
 * Try to execute block
 * Even worse than tryOrDefault. Accepts default expression
 * Usage: { mightThrow() } onError { 42 }
 */
@Evilness(HowEvil.VERY_EVIL)
infix fun <T> (() -> T).onError(default: () -> T) = tryOrDefault(this, default)

/**
 * Try to execute block. You don't care what happens.
 */
@Evilness(HowEvil.SUPER_EVIL)
fun consumeExceptions(block: () -> Unit) = tryOrDefault(block) { Unit }

/**
 * Try to execute block or return null
 */
@Evilness(HowEvil.SUPER_EVIL)
fun <T> tryOrNull(block: () -> T) = tryOrDefaultNullable(block, null)