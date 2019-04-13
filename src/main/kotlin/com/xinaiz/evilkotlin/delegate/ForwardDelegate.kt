package com.xinaiz.evilkotlin.delegate

import kotlin.reflect.KProperty
import kotlin.reflect.KMutableProperty

class Forward<T> (private val originalProperty: KProperty<T>){
  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return originalProperty.getter.call()
  }
}

class ForwardMutable<T> (private val originalProperty: KMutableProperty<T>){
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    originalProperty.setter.call(value)
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return originalProperty.getter.call()
  }
}

fun <T> forward(originalProperty: KProperty<T>) = Forward(originalProperty)
fun <T> forward(originalProperty: KMutableProperty<T>) = ForwardMutable(originalProperty)
