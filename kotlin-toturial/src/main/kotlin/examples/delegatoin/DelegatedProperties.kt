package main.kotlin.examples.delegatoin

import kotlin.reflect.KProperty

/**
 * 将Example中的p属性通过by的方式委托到Delegate上
 * 委托对象要实现两个方法getValue/setValue 这两个方法的参数
 * 类型是固定的,其中Any?可以换成请求委托的类(Example)
 * 若需要委托的属性为不可变属性时(val) 则只需要实现getValue
 *
 */
class Example {
    var p: String by Delegate()

    override fun toString(): String {
        return "Example Class"
    }
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' in $thisRef"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
}