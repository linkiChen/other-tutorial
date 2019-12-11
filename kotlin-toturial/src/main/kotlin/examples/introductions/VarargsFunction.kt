package main.kotlin.examples.introductions

fun printAll(vararg objs: Any) {
    for (obj in objs) println(obj.toString())
}

fun printAllWithPrefix(vararg objs: Any, prefix: String) {
    for (obj in objs) println("$prefix $obj")
}

fun log(vararg entries: String) {
    printAll(entries)
}

/**
 * 对于vararg类型的参数,加上*前缀,编译器会将其用','分隔开
 */
fun log2(vararg entries: String) {
    printAll(*entries)
}

fun main() {
    printAll("Hello", "Scala", "Java", "Kotlin")
    printAllWithPrefix("Hello", "Scala", "Java", "Kotlin", prefix = "你好")
    println("----------------------------------")
    log("Hello", "Scala", "Java", "Kotlin")
    log2("Hello", "Scala", "Java", "Kotlin")
}