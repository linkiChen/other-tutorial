package main.kotlin.examples.collections

fun main() {
    fun_filter()
    fun_map()
    fun_any()
    fun_all()
    fun_none()
}

/**
 * 过滤
 */
fun  fun_filter() {
    println("********************** filter **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")
    val positives = numbers.filter { x -> x > 0 }
    println("positives:$positives")

    // 使用it表示参数,这种用户只能用it,否则只能用上面的方式
    val negatives = numbers.filter { it < 0 }
    println("negatives:$negatives")
}

/**
 * 映射
 */
fun fun_map() {
    println("\n********************** map **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")
    val doubled = numbers.map { x -> x * 2 }
    println("2 times :$doubled")
    val tripled = numbers.map { it * 3 }
    println("3 times :$tripled")
}

/**
 * 任何一个满足条件
 */
fun fun_any() {
    println("\n********************** any **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")
    val anyNegative = numbers.any { it < 0 }
    println("negatives:$anyNegative")
    val anyGT6 = numbers.any() { it > 6 }
    println("are there any number great than 6: $anyGT6")
}

/**
 * 所有的都满足条件
 */
fun fun_all() {
    println("\n********************** all **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")

    val allEven = numbers.all { it % 2 == 0 }
    println("all numbers it % 2 == 0 :$allEven")
    val allLess6 = numbers.all { it < 6 }
    println("all numbers less than 6:$allLess6")
}

fun fun_none() {
    println("\n********************** none **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")

    val allEven = numbers.none { it % 2 == 0 }
    println("no number it % 2 == 0 :$allEven")
    val allLess6 = numbers.none { it > 6 }
    println("all numbers less than 6:$allLess6")
}