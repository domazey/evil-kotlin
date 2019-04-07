package com.xinaiz.evilkotlin.proxy

import com.xinaiz.evilkotlin.cast.cast
import java.lang.reflect.Method
import java.lang.reflect.Proxy

inline fun <reified T> proxyOf(
  proxyClass: Class<T>,
  vararg interfaces: Class<*>,
  crossinline invocation: (T, Method, Array<Any?>?) -> Any?
) =
  proxyClass.cast(Proxy.newProxyInstance(Nothing::class.java.classLoader, interfaces) { abc, method, args ->
    invocation(abc.cast(), method, args)
  })