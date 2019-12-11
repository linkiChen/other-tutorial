package main.kotlin.examples.introductions

/**
 * 中缀函数：Kotlin允许在不使用括号和点号的情况下调用函数，那么这种函数被称为 infix函数。
 * 中缀函数需要满足以下要求:
 * 1. 它们必须是成员函数或扩展函数
 * 2. 它们必须只有一个参数
 * 3. 其参数不得接受可变数量的参数且不能有默认值
 *
 * 需要注意的是: 中缀函数总是要求指定接收者与参数,当使用中缀表示法在当前接收者上调用方法时,
 * 需要显式使用 this;不能像常规方法调用那样省略(查看InfixFun)
 *
 * 中缀函数与操作符的优先级:
 * 1. 中缀函数调用的优先级低于算术操作符、类型转换以及 rangeTo 操作符
 * 2. 中缀函数调用的优先级高于布尔操作符 && 与 ||、is- 与 in- 检测以及其他一些操作符。
 */

fun main() {
    infix fun Int.times(str: String) = str.repeat(this)
    println(3 times "Hello ")

    val pair = "Hello " to "World"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val ontoPair = "Hello " onto "Kotlin"
    println(ontoPair)

    val sophia = Person("Sophia")
    sophia likes Person("claudia")
    println(sophia.likedPeople.size)

}

fun infixAndOperator() {
    1 shl 2 + 3 // 1 shl (2 + 3)
    0 until 2 * 3 // 0 until (2 * 3)

}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) = likedPeople.add(other)
}

class InfixFun(val value: String) {
    infix fun add(str: String) = value + str;
    fun callAdd() {
        this add " suffix"
        add(" suffix")
        // 错误:必须指定接收者
//        add "suffix"
    }
}