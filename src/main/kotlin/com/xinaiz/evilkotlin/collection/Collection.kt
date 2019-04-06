package com.xinaiz.evilkotlin.collection

import com.xinaiz.evilkotlin.qualifiers.Evilness
import com.xinaiz.evilkotlin.qualifiers.HowEvil.WHY_IS_THIS_IN_THIS_LIBRARY

/**
 * Why is this missing from the standard library...
 */
@Evilness(WHY_IS_THIS_IN_THIS_LIBRARY)
inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
  var sum = 0L
  for (element in this) {
    sum += selector(element)
  }
  return sum
}