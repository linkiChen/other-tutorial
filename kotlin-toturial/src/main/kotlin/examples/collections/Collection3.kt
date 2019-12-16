package main.kotlin.examples.collections


fun main() {
    fun_find()
    first_last()
    first_last_or_null()
    fun_coount()
}

fun fun_find() {

    println("************************* find *************************")
    val works = listOf("Lets", "find", "something", "in", "collection", "somehow")
    println("words:$works")
    val first = works.find { it.startsWith("some") }
    println("first match :$first")
    val last = works.findLast { it.startsWith("some") }
    println("last match: $last")
    val nothing = works.find { it.contains("nothing") }
    println("no match:$nothing")
}

fun first_last() {
    println("********************** first last **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")

    val first = numbers.first()
    val last = numbers.last()
    println("first: $first,last: $last")
    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }
    println("first and first:$firstEven,last:$lastOdd")
}

fun first_last_or_null() {
    println("********************** first last orNull **********************")
    val words = listOf("foo", "bar", "baz", "faz")
    val empty = emptyList<String>()

    val first = empty.firstOrNull()
    val last = empty.lastOrNull()
    println("first last orNull:$first , $last")
    val firstF = words.firstOrNull { it.startsWith('f') }
    val firstZ = words.firstOrNull { it.startsWith('z') }
    println("orNull firstF:$firstF,orNull firstZ:$firstZ")
    val lastF = words.lastOrNull { it.endsWith('f') }
    val lastZ = words.lastOrNull { it.endsWith('z') }
    println("orNull lastF: $lastF ,orNull lastZ $lastZ")
}

fun fun_coount() {
    println("********************** count **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")

    val totalCount = numbers.count()
    val evenCount = numbers.count { it % 2 == 0 }
    println("total num count:$totalCount")
    println("%2==0 count:$evenCount")
}