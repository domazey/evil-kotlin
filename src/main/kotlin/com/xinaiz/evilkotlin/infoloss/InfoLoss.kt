package com.xinaiz.evilkotlin.infoloss

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 * YOU LOSE:
 * 1. The cause what happened
 * 2. Dignity
 */

@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(block: () -> T, default: T)
    = try { block() } catch (ex: Throwable) { default }

/**
 * The same as [tryOrDefault], but accepts expression for default value
 */
@Evilness(HowEvil.VERY_EVIL)
fun <T> tryOrDefault(block: () -> T, default: () -> T)
    = try { block() } catch (ex: Throwable) { default() }

