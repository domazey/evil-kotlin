package com.xinaiz.evilkotlin.tuple

import java.io.Serializable

data class Decuple<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J>(
  val first: A,
  val second: B,
  val third: C,
  val fourth: D,
  val fifth: E,
  val sixth: F,
  val seventh: G,
  val eighth: H,
  val ninth: I,
  val tenth: J
) : Serializable {

  override fun toString(): String = "($first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth)"
}

fun <T> Decuple<T, T, T, T, T, T, T, T, T, T>.toList(): List<T> =
  listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth)
