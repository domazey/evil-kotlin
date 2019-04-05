package com.xinaiz.evilkotlin.delegate

import kotlin.reflect.KProperty

open class QuickReadDelegate<T>(private val getFunc: (String) -> T) {
  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return getFunc(property.name)
  }
}

open class QuickWriteDelegate<T>(private val setFunc: (String, T) -> Unit) {
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    setFunc(property.name, value)
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    throw UnsupportedOperationException("Delegated property $property can only set it's value")
  }
}

open class QuickReadWriteDelegate<T>(getFunc: (String) -> T, private val setFunc: (String, T) -> Unit) {
  private val readDelegate = QuickReadDelegate(getFunc)
  private val writeDelegate = QuickWriteDelegate(setFunc)

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return readDelegate.getValue(thisRef, property)
  }

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    return writeDelegate.setValue(property, property, value)
  }
}


fun <T> quickRead(getFunc: (String) -> T) = QuickReadDelegate(getFunc)
fun <T> quickWrite(setFunc: (String, T) -> Unit) = QuickWriteDelegate(setFunc)
fun <T> quickReadWrite(getFunc: (String) -> T, setFunc: (String, T) -> Unit) = QuickReadWriteDelegate(getFunc, setFunc)