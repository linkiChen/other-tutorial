package main.kotlin.examples.introductions

/**
 * Int的times函数原来只是操作数字之间的相乘的,
 * 但是通过operator进行升级,将其升级为可接收String类型的参数
 */
operator fun Int.times(str: String) = str.repeat(this)

operator fun String.get(range: IntRange) = substring(range)

/**
 * 某些功能可以通过'operator'声明进行升级,这将允许他们通过相应的操作符进行调用
 */
fun main() {
    println(2 * "Hello ")

    val str = "Never give up,because you get no chance to give up"
    println(str[0..9])
}