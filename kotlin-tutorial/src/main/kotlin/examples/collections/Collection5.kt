package main.kotlin.examples.collections

fun main() {
    fun_min_max()
    fun_sorted()
    fun_map_element()
}

fun fun_min_max() {
    println("************************ min max ************************")
    val numbers = listOf(1, 3, 5)
    val empty = emptyList<Int>()

    println("Numbers:$numbers\nmin = ${numbers.min()},\nmax = ${numbers.max()}")
    println("\nEmpty: $empty,\nmin = ${empty.min()},\nmax = ${empty.max()}")
}

fun fun_sorted() {
    println("************************ sorted ************************")
    val shuffled = listOf(8, 1, 6, 4, 9, 2)
    val natural = shuffled.sorted()
    val inverted = shuffled.sortedBy { -it }

    println("numbers:$shuffled")
    println("natural sorted:$natural")
    println("inverted sorted:$inverted")
}

fun fun_map_element() {
    println("************************ Map element ************************")
    val map = mapOf("key" to 34)

    // 通过map["key"]的形式获取Map中的元素时,如果key有相应的值则返回,若没有值则返回null
    val value1 = map["key"]
    val value2 = map["key2"]

    val value3 = map.getValue("key")

    // 创建一个有默认值的map
    val mapWithDefault = map.withDefault { k -> k.length }
    // 有默认值的Map中,如果key没有相应的值,则返回默认值
    val value4 = mapWithDefault.getValue("key2")

    try {
        // 没有默认值的map中,通过.getValue的形式获取值时,如果没有相应的值则否发生异常
        map.getValue("key5")
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }
}