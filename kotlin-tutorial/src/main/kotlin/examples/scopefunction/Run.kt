package main.kotlin.examples.scopefunction

/**
 * 和let一样,run也是一个作用域函数,
 * 与let不同的是run中使用this访问对象,而let是使用it
 * 只是作为一个参数在使用,而this则表示对象本身,
 * run的代码代中可以使用this调用对象本身的一些方法
 */
fun getNullableLength(ns: String?) {
    println("for \"$ns\":")
    ns?.run {
        println("\t is Empty? ${this.isEmpty()}")
        println("\t length = $length")
        length
    }
}

fun main() {
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("run scoping function with kotlin")
}