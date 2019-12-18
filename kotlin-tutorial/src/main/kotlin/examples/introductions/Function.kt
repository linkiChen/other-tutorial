package main.kotlin.examples.introductions

/**
 * 定义一个函数,需要一个String类型的参数,
 * 返回值为Unit(也就是没有返回值,相当于java中的void)
 */

fun printMessage(message: String): Unit {
    println(message)
}

/**
 * 参数带默认值,当调用者没有传递prefix参数时,prefix的值则为默认值
 */
fun printMessageWithPrefix(message: String, prefix: String = "Info = ") {
    println("[$prefix] $message")
}

/**
 * 带返回值类型的函数,返回值为Int
 */
fun sum(x: Int, y: Int): Int {
    return x + y
}

/**
 * 不带返回值类型的函数,但其返回值类型可以由编译器推断出来
 * 只有一条语句的函数体可以不需要'{'及'}'
 */
fun multiply(x: Int, y: Int) = x * y

fun main() {
    printMessage("Hello Kotlin")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Kotlin")

    // 使用全名参数调用函数时可以不依照函数参数的定义顺序调用此函数
    printMessageWithPrefix(prefix = "Log", message = "World")
    println(sum(2, 3))
    println(multiply(4, 5))
}