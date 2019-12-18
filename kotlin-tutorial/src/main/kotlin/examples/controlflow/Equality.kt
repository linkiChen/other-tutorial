package main.kotlin.examples.controlflow

fun main() {
    val authors = setOf<String>("Shakespeare", "Hemingway", "Twain")
    val writer = setOf<String>("Twain", "Shakespeare", "Hemingway")

    // 比较内容是否相同 相当于调用equals方法
    println(authors == writer)
    // 比较两个常量在内存中的地址是否相同
    println(authors === writer)
}