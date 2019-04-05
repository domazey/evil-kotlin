package com.xinaiz.evilkotlin.qualifiers

/**
 * Annotation that specifies how evil is something
 */
@Retention(AnnotationRetention.RUNTIME)
annotation class Evilness(
  val value: HowEvil
)