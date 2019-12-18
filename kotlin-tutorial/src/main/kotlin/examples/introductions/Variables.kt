package main.kotlin.examples.introductions

fun main() {
    // 定义一个变量,其类型为String,实际上编译器可以推断出a的类型,
    // 这里可以不用显式地声明其类型
    var a: String = "initial"
    println("a=$a")
    a = "variable a's value has change"
    println("a=$a")
    // 显示地声明一个常量,同理,其类型编译器也可以推断出来,可以不用显式地声明类型
    val b: Int = 1
    // 变量初始化后其值是不可以改变的
//    b = 3

    val c = 3
    println("b=$b")
    println("c=$c")

    val e: Int
    e = 4
    // 声明的常量/变量在其使用前需要先初始化才可以使用,否则编译会不通过
    println("e=$e")

    var f: String
//    println("f=$f")
}