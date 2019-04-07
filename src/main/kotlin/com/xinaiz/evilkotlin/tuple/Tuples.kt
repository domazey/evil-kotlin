package com.xinaiz.evilkotlin.tuple

import com.xinaiz.evilkotlin.tuple.AddPos.*
import com.xinaiz.evilkotlin.tuple.DropPos.*

/**
 * Helper class to add or remove elements from tuples at given postion
 * Adding at Pos1 means that new element will be at position 1 (first)
 * Removing at Pos1 means that first element will be removed
 */

sealed class AddPos<T : Any?>(val value: T) {
  @Deprecated("Do not use directly", replaceWith = ReplaceWith("first(value)"))
  class AddAt1<T1 : Any?>(value: T1) : AddPos<T1>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("second(value)"))
  class AddAt2<T2 : Any?>(value: T2) : AddPos<T2>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("third(value)"))
  class AddAt3<T3 : Any?>(value: T3) : AddPos<T3>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("fourth(value)"))
  class AddAt4<T4 : Any?>(value: T4) : AddPos<T4>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("fifth(value)"))
  class AddAt5<T5 : Any?>(value: T5) : AddPos<T5>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("sixth(value)"))
  class AddAt6<T6 : Any?>(value: T6) : AddPos<T6>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("seventh(value)"))
  class AddAt7<T7 : Any?>(value: T7) : AddPos<T7>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("eighth(value)"))
  class AddAt8<T8 : Any?>(value: T8) : AddPos<T8>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("ninth(value)"))
  class AddAt9<T9 : Any?>(value: T9) : AddPos<T9>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("tenth(value)"))
  class AddAt10<T10 : Any?>(value: T10) : AddPos<T10>(value)

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("last(value)"))
  class AddLast<TL : Any?>(value: TL) : AddPos<TL>(value)
}

sealed class DropPos {
  @Deprecated("Do not use directly", replaceWith = ReplaceWith("first()"))
  class DropAt1 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("second()"))
  class DropAt2 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("third()"))
  class DropAt3 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("fourth()"))
  class DropAt4 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("fifth()"))
  class DropAt5 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("sixth()"))
  class DropAt6 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("seventh()"))
  class DropAt7 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("eighth()"))
  class DropAt8 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("ninth()"))
  class DropAt9 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("tenth()"))
  class DropAt10 : DropPos()

  @Deprecated("Do not use directly", replaceWith = ReplaceWith("last()"))
  class DropLast : DropPos()
}

@Suppress("DEPRECATION")
object Positions {
  fun <T> first(value: T) = AddAt1(value)
  fun <T> second(value: T) = AddAt2(value)
  fun <T> third(value: T) = AddAt3(value)
  fun <T> fourth(value: T) = AddAt4(value)
  fun <T> fifth(value: T) = AddAt5(value)
  fun <T> sixth(value: T) = AddAt6(value)
  fun <T> seventh(value: T) = AddAt7(value)
  fun <T> eighth(value: T) = AddAt8(value)
  fun <T> ninth(value: T) = AddAt9(value)
  fun <T> tenth(value: T) = AddAt10(value)
  fun <T> last(value: T) = AddLast(value)

  fun first() = DropAt1()
  fun second() = DropAt2()
  fun third() = DropAt3()
  fun fourth() = DropAt4()
  fun fifth() = DropAt5()
  fun sixth() = DropAt6()
  fun seventh() = DropAt7()
  fun eighth() = DropAt8()
  fun ninth() = DropAt9()
  fun tenth() = DropAt10()
  fun last() = DropLast()
}

// Pair

infix fun <A, B, C> Pair<A, B>.add(newFirst: AddAt1<C>) = Triple(newFirst.value, first, second)
infix fun <A, B, C> Pair<A, B>.add(newSecond: AddAt2<C>) = Triple(first, newSecond.value, second)
infix fun <A, B, C> Pair<A, B>.add(newThird: AddAt3<C>) = Triple(first, second, newThird.value)
infix fun <A, B, C> Pair<A, B>.add(last: AddLast<C>) = add(Positions.third(last.value))

infix fun <A, B> Pair<A, B>.drop(first: DropAt1) = second
infix fun <A, B> Pair<A, B>.drop(second: DropAt2) = first
infix fun <A, B> Pair<A, B>.drop(last: DropLast) = drop(Positions.second())

// Triple 

infix fun <A, B, C, D> Triple<A, B, C>.add(newFirst: AddAt1<D>) = Quadruple(newFirst.value, first, second, third)
infix fun <A, B, C, D> Triple<A, B, C>.add(newSecond: AddAt2<D>) = Quadruple(first, newSecond.value, second, third)
infix fun <A, B, C, D> Triple<A, B, C>.add(newThird: AddAt3<D>) = Quadruple(first, second, newThird.value, third)
infix fun <A, B, C, D> Triple<A, B, C>.add(newFourth: AddAt4<D>) = Quadruple(first, second, third, newFourth.value)
infix fun <A, B, C, D> Triple<A, B, C>.add(last: AddLast<D>) = add(Positions.fourth(last.value))

infix fun <A, B, C> Triple<A, B, C>.drop(first: DropAt1) = Pair(second, third)
infix fun <A, B, C> Triple<A, B, C>.drop(second: DropAt2) = Pair(first, third)
infix fun <A, B, C> Triple<A, B, C>.drop(third: DropAt3) = Pair(first, second)
infix fun <A, B, C> Triple<A, B, C>.drop(last: DropLast) = drop(Positions.third())

// Quadruple 

infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(newFirst: AddAt1<E>) = Quintuple(newFirst.value, first, second, third, fourth)
infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(newSecond: AddAt2<E>) = Quintuple(first, newSecond.value, second, third, fourth)
infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(newThird: AddAt3<E>) = Quintuple(first, second, newThird.value, third, fourth)
infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(newFourth: AddAt4<E>) = Quintuple(first, second, third, newFourth.value, fourth)
infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(newFifth: AddAt5<E>) = Quintuple(first, second, third, fourth, newFifth.value)
infix fun <A, B, C, D, E> Quadruple<A, B, C, D>.add(last: AddLast<E>) = add(Positions.fifth(last.value))

infix fun <A, B, C, D> Quadruple<A, B, C, D>.drop(first: DropAt1) = Triple(second, third, fourth)
infix fun <A, B, C, D> Quadruple<A, B, C, D>.drop(second: DropAt2) = Triple(first, third, fourth)
infix fun <A, B, C, D> Quadruple<A, B, C, D>.drop(third: DropAt3) = Triple(first, second, fourth)
infix fun <A, B, C, D> Quadruple<A, B, C, D>.drop(fourth: DropAt4) = Triple(first, second, third)
infix fun <A, B, C, D> Quadruple<A, B, C, D>.drop(last: DropLast) = drop(Positions.fourth())

// Quintuple 

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newFirst: AddAt1<F>) =
  Sextuple(newFirst.value, first, second, third, fourth, fifth)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newSecond: AddAt2<F>) =
  Sextuple(first, newSecond.value, second, third, fourth, fifth)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newThird: AddAt3<F>) =
  Sextuple(first, second, newThird.value, third, fourth, fifth)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newFourth: AddAt4<F>) =
  Sextuple(first, second, third, newFourth.value, fourth, fifth)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newFifth: AddAt5<F>) =
  Sextuple(first, second, third, fourth, newFifth.value, fifth)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(newSixth: AddAt6<F>) =
  Sextuple(first, second, third, fourth, fifth, newSixth.value)

infix fun <A, B, C, D, E, F> Quintuple<A, B, C, D, E>.add(last: AddLast<F>) = add(Positions.sixth(last.value))

infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(first: DropAt1) = Quadruple(second, third, fourth, fifth)
infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(second: DropAt2) = Quadruple(first, third, fourth, fifth)
infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(third: DropAt3) = Quadruple(first, second, fourth, fifth)
infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(fourth: DropAt4) = Quadruple(first, second, third, fifth)
infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(fifth: DropAt5) = Quadruple(first, second, third, fourth)
infix fun <A, B, C, D, E> Quintuple<A, B, C, D, E>.drop(last: DropLast) = drop(Positions.fifth())

// Sextuple 

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newFirst: AddAt1<G>) =
  Septuple(newFirst.value, first, second, third, fourth, fifth, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newSecond: AddAt2<G>) =
  Septuple(first, newSecond.value, second, third, fourth, fifth, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newThird: AddAt3<G>) =
  Septuple(first, second, newThird.value, third, fourth, fifth, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newFourth: AddAt4<G>) =
  Septuple(first, second, third, newFourth.value, fourth, fifth, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newFifth: AddAt5<G>) =
  Septuple(first, second, third, fourth, newFifth.value, fifth, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newSixth: AddAt6<G>) =
  Septuple(first, second, third, fourth, fifth, newSixth.value, sixth)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(newSeventh: AddAt7<G>) =
  Septuple(first, second, third, fourth, fifth, sixth, newSeventh.value)

infix fun <A, B, C, D, E, F, G> Sextuple<A, B, C, D, E, F>.add(last: AddLast<G>) = add(Positions.seventh(last.value))

infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(first: DropAt1) = Quintuple(second, third, fourth, fifth, sixth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(second: DropAt2) = Quintuple(first, third, fourth, fifth, sixth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(third: DropAt3) = Quintuple(first, second, fourth, fifth, sixth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(fourth: DropAt4) = Quintuple(first, second, third, fifth, sixth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(fifth: DropAt5) = Quintuple(first, second, third, fourth, sixth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(sixth: DropAt6) = Quintuple(first, second, third, fourth, fifth)
infix fun <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F>.drop(last: DropLast) = drop(Positions.sixth())

// Septuple

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newFirst: AddAt1<H>) =
  Octuple(newFirst.value, first, second, third, fourth, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newSecond: AddAt2<H>) =
  Octuple(first, newSecond.value, second, third, fourth, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newThird: AddAt3<H>) =
  Octuple(first, second, newThird.value, third, fourth, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newFourth: AddAt4<H>) =
  Octuple(first, second, third, newFourth.value, fourth, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newFifth: AddAt5<H>) =
  Octuple(first, second, third, fourth, newFifth.value, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newSixth: AddAt6<H>) =
  Octuple(first, second, third, fourth, fifth, newSixth.value, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newSeventh: AddAt7<H>) =
  Octuple(first, second, third, fourth, fifth, sixth, newSeventh.value, seventh)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(newEighth: AddAt8<H>) =
  Octuple(first, second, third, fourth, fifth, sixth, seventh, newEighth.value)

infix fun <A, B, C, D, E, F, G, H> Septuple<A, B, C, D, E, F, G>.add(last: AddLast<H>) = add(Positions.eighth(last.value))

infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(first: DropAt1) = Sextuple(second, third, fourth, fifth, sixth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(second: DropAt2) = Sextuple(first, third, fourth, fifth, sixth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(third: DropAt3) = Sextuple(first, second, fourth, fifth, sixth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(fourth: DropAt4) = Sextuple(first, second, third, fifth, sixth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(fifth: DropAt5) = Sextuple(first, second, third, fourth, sixth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(sixth: DropAt6) = Sextuple(first, second, third, fourth, fifth, seventh)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(seventh: DropAt7) = Sextuple(first, second, third, fourth, fifth, sixth)
infix fun <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G>.drop(last: DropLast) = drop(Positions.seventh())

// Octuple

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newFirst: AddAt1<I>) =
  Nonuple(newFirst.value, first, second, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newSecond: AddAt2<I>) =
  Nonuple(first, newSecond.value, second, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newThird: AddAt3<I>) =
  Nonuple(first, second, newThird.value, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newFourth: AddAt4<I>) =
  Nonuple(first, second, third, newFourth.value, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newFifth: AddAt5<I>) =
  Nonuple(first, second, third, fourth, newFifth.value, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newSixth: AddAt6<I>) =
  Nonuple(first, second, third, fourth, fifth, newSixth.value, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newSeventh: AddAt7<I>) =
  Nonuple(first, second, third, fourth, fifth, sixth, newSeventh.value, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newEighth: AddAt8<I>) =
  Nonuple(first, second, third, fourth, fifth, sixth, seventh, newEighth.value, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(newNinth: AddAt9<I>) =
  Nonuple(first, second, third, fourth, fifth, sixth, seventh, eighth, newNinth.value)

infix fun <A, B, C, D, E, F, G, H, I> Octuple<A, B, C, D, E, F, G, H>.add(last: AddLast<I>) = add(Positions.ninth(last.value))

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(first: DropAt1) =
  Septuple(second, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(second: DropAt2) =
  Septuple(first, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(third: DropAt3) =
  Septuple(first, second, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(fourth: DropAt4) =
  Septuple(first, second, third, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(fifth: DropAt5) =
  Septuple(first, second, third, fourth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(sixth: DropAt6) =
  Septuple(first, second, third, fourth, fifth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(seventh: DropAt7) =
  Septuple(first, second, third, fourth, fifth, sixth, eighth)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(eighth: DropAt8) =
  Septuple(first, second, third, fourth, fifth, sixth, seventh)

infix fun <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H>.drop(last: DropLast) = drop(Positions.eighth())

// Nonuple

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newFirst: AddAt1<J>) =
  Decuple(newFirst.value, first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newSecond: AddAt2<J>) =
  Decuple(first, newSecond.value, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newThird: AddAt3<J>) =
  Decuple(first, second, newThird.value, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newFourth: AddAt4<J>) =
  Decuple(first, second, third, newFourth.value, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newFifth: AddAt5<J>) =
  Decuple(first, second, third, fourth, newFifth.value, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newSixth: AddAt6<J>) =
  Decuple(first, second, third, fourth, fifth, newSixth.value, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newSeventh: AddAt7<J>) =
  Decuple(first, second, third, fourth, fifth, sixth, newSeventh.value, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newEighth: AddAt8<J>) =
  Decuple(first, second, third, fourth, fifth, sixth, seventh, newEighth.value, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(newNinth: AddAt9<J>) =
  Decuple(first, second, third, fourth, fifth, sixth, seventh, eighth, newNinth.value, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Nonuple<A, B, C, D, E, F, G, H, I>.add(last: AddLast<J>) = add(Positions.ninth(last.value))

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(first: DropAt1) =
  Octuple(second, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(second: DropAt2) =
  Octuple(first, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(third: DropAt3) =
  Octuple(first, second, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(fourth: DropAt4) =
  Octuple(first, second, third, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(fifth: DropAt5) =
  Octuple(first, second, third, fourth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(sixth: DropAt6) =
  Octuple(first, second, third, fourth, fifth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(seventh: DropAt7) =
  Octuple(first, second, third, fourth, fifth, sixth, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(eighth: DropAt8) =
  Octuple(first, second, third, fourth, fifth, sixth, seventh, ninth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(ninth: DropAt9) =
  Octuple(first, second, third, fourth, fifth, sixth, seventh, eighth)

infix fun <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I>.drop(last: DropLast) = drop(Positions.ninth())

// Decuple (only drop)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(first: DropAt1) =
  Nonuple(second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(second: DropAt2) =
  Nonuple(first, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(third: DropAt3) =
  Nonuple(first, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(fourth: DropAt4) =
  Nonuple(first, second, third, fifth, sixth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(fifth: DropAt5) =
  Nonuple(first, second, third, fourth, sixth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(sixth: DropAt6) =
  Nonuple(first, second, third, fourth, fifth, seventh, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(seventh: DropAt7) =
  Nonuple(first, second, third, fourth, fifth, sixth, eighth, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(eighth: DropAt8) =
  Nonuple(first, second, third, fourth, fifth, sixth, seventh, ninth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(ninth: DropAt9) =
  Nonuple(first, second, third, fourth, fifth, sixth, seventh, eighth, tenth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(tenth: DropAt10) =
  Nonuple(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

infix fun <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J>.drop(last: DropLast) = drop(Positions.tenth())
