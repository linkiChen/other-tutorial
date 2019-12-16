package main.kotlin.examples.functional

/**
 * 定义一个接收函数作为参数的高阶函数calculate
 * 作为参数的函数operation接收两个Int类型的参数,返回值为Int类型
 */
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// sum符合operation的函数定义
fun sum(x: Int, y: Int) = x + y

fun main() {
    val sumResult = calculate(2, 5, ::sum)
    val mulResult = calculate(4, 5, { a, b -> a * b })

    val mulRes = calculate(5, 6) { a, b -> a * b }

    println("sumResult=$sumResult,mulResult=$mulResult")

    // 这里的func实际就变成了square
    val func = operation()
    println(func(5))
}

// 定义一个返回值是函数的高阶函数
fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x