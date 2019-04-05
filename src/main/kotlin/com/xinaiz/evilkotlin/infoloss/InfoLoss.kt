package com.xinaiz.evilkotlin.infoloss

/**
 * Try to execute block.
 * If something bad happens ¯\_(ツ)_/¯ return a default value.
 */
inline fun <reified T> tryOrDefault(block: () -> T, default: T) = try {
  block()
} catch (ex: Throwable) {
  default
}
