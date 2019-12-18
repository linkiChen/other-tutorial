package main.kotlin.examples.controlflow

fun main() {
    number_range()
    char_range()
}

fun number_range() {
    for (i in 0..3) print("$i ")
    println()
    // 带步长的区间
    for (i in 2..8 step 2) print("$i ")
    println()
    for (i in 3 downTo 0) print("$i ")

}

fun char_range() {
    println()
    for (c in 'a'..'d') print("$c ")
    println()
    for (c in 'z' downTo 's' step 2) print("$c ")
}