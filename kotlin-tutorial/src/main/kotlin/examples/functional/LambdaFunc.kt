package main.kotlin.examples.functional


// 最全的lambda表达式的定义
val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }

val upperCase2: (String) -> String = { str -> str.toUpperCase() }

val upperCase3 = { str: String -> str.toUpperCase() }

//val uppercase4 = {str->str.toUpperCase()}

// it指代参数
val upperCase5: (String) -> String = { it.toUpperCase() }
// 方法引用的方法调用toUpperCase
val upperCase6: (String) -> String = String::toUpperCase


fun main() {
    println(upperCase1("hello"))
    println(upperCase2("world"))
    println(upperCase3("kotlin"))
    println(upperCase5("scala"))
    println(upperCase6("java"))
}