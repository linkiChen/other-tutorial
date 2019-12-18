package main.kotlin.examples.controlflow

fun main() {
    val a = 3
    val b = 4
    val c = if (a > b) a else b

    println(max(a, b))
}

// 在这里if是个表达式,它会返回一个值
fun max(a: Int, b: Int) = if (a > b) a else b

fun min(a: Int, b: Int) {
    val c = if (a > b) b else a
}