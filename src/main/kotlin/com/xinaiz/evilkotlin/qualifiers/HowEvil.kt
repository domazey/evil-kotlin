package com.xinaiz.evilkotlin.qualifiers

enum class HowEvil(val value: Int) {

  /**
   * Actually not evil.
   */
  WHY_IS_THIS_IN_THIS_LIBRARY(0),

  /**
   * All kinds of local discontinuity, 1-liner haxs.
   * Generally stuff that can be easily fixed.
   * For example:
   * - use 4 spaces to intend a single block of code in project that use 2.
   * - if you write hard-to-read single-liners of code
   */
  LITTLE_EVIL(1),

  /**
   * Small tricks and haxs. Also code that could easily be simplified.
   * Works, but good programmer would never write it, even by mistake.
   * Might pass a code review.
   */
  KINDA_EVIL(2),

  /**
   * Fighting with libraries and language. Creating classes that do too much. Files with >1000 lines of code.
   * Almost impossible to pass a code review.
   */
  PRETTY_EVIL(3),

  /**
   * Unnecessary usage of reflection on stable classes that will not likely change and break the code.
   * Writing verbose constructs that don't make much sense.
   * Writing unreadable code, single character variable names
   * Complex Kotlin Expressions
   */
  JUST_EVIL(4),

  /**
   * Usage of reflection on "hot" classes that might change in the future.
   * Usage of try-catch expressions and discarding exceptions
   * Usage of !! on references that might be null in current context
   */
  VERY_EVIL(5),

  /**
   * Reflection-driven development.
   */
  SUPER_EVIL(6),

  /**
   * Holy!
   */
  EXTREMELY_EVIL(7),

  /**
   * Please stop.
   */
  CORRUPTLY_EVIL(8),

  /**
   * Save your soul
   */
  DIABOLICALLY_EVIL(9),

  /**
   * [*]
   */
  DEADLY_EVIL(10),
}