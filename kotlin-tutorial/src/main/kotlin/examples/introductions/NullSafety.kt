package main.kotlin.examples.introductions

fun main() {
    // Kotlin 中变量默认是不可为空的
    var neverNull = "This can't be null"
//    不可为这的变量不能赋予null
//    neverNull = null

    var nullable: String? = "This can be null"
    nullable = null

    // 由编译器推断出其类型的变量也不可为空
    var inferredNonNull = "The compiler assumes not-null"
//    inferredNonNull = null

    strLength(neverNull)
    // 类型不匹配
//    strLength(nullable)

    println(describeString(nullable))
    println(describeString(inferredNonNull))
}

fun strLength(notNull: String): Int {
    return notNull.length
}

fun describeString(maybeStr: String?): String {
    if (maybeStr != null && maybeStr.length > 0) return "String of length is ${maybeStr.length}" else return "Empty or null String"
}