package main.kotlin.examples.controlflow

class MyClass

fun cases(obj: Any) {
    when (obj) {
        // 从上至下依次判断,直至找到第一个匹配的就中断
        // 匹配,如果都没有匹配成功,则执行else
        1 -> println("Number One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

fun wherAssign(obj: Any): Any {
    val result = when (obj) {
        1 -> "one"
        "Hello" -> "String Hello"
        is Long -> false
        else -> "Other"
    }
    return result
}

fun main() {
    cases("Hello")
    cases(1)
    cases(1.0)
    cases(0L)
    cases(MyClass())
    cases("hello")


}