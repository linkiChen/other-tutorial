package main.kotlin.examples.collections


fun main() {
    fun_zip()
    get_or_else()
}

fun fun_zip() {
    println("******************** zip ********************")
    val A = listOf('a', 'b', 'c')
    val B = listOf(1, 2, 3)
    val C = listOf('A', 'B', 'C', 'D')

    val resultPairs = A zip B
    val resultReduce = A.zip(B) { a, b -> "$a,$b" }
    // 两个元素个数不相同的list zip时,最终得到的list中的元素个数以元素少的list个数为准
    val resultRef = A zip C

    println("resultPairs:$resultPairs")
    println("resultReduce:$resultReduce")
    println("resultRef:$resultRef")
    println("inverse resultRef:${C zip A}")
}

fun get_or_else() {
    println("******************** getOrElse ********************")
    val list = listOf(0, 10, 30)
    println("index 1:${list.getOrElse(1) { 42 }}")
    println("index 5:${list.getOrElse(5) { 32 }}")

    val map = mutableMapOf<String, Int?>()
    println("map getOrElse:${map.getOrElse("x") { 1 }}")

    map["x"] = 3
    println("map getOrElse:${map.getOrElse("x") { 1 }}")

    map["y"] = null
    println(map.getOrElse("y") { 1 })
}