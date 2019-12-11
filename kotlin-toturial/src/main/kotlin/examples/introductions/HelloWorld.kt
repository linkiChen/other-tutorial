package main.kotlin.examples.introductions

/**
 * main():主程序入口,1.3之前入口函数必须要有参数如下:
 * fun main(args: Array<String>) {
 *  ......
 * }
 * 1.3及之后的主程序入口可以不包括参数
 * Kotlin中的很多内置函数都是隐匿导入的,如:println.
 * 每个语句块后的';'都是可以省略的
 */
fun main() {
    println("Hello World");
    print("Hello Kotlin")
}