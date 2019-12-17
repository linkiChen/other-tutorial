package main.kotlin.examples.scopefunction

/**
 * let可以用户作用域或者空检查
 * 在对象上调用let可以执行指定的代码块,并且返回代码块中
 * 最后一句表达式的执行结果,在代码块内部可以使用it代表关联
 * 的对象
 */

val empty = "test".let {
    customerPrint(it)
    it.isEmpty()
}

fun customerPrint(obj: Any) {
    println("customerPrint: $obj")
}

fun printNonNull(str: String?) {
    println("Printing \"$str\":")
    str?.let {
        print("\t")
        customerPrint(it)
        println()
    }
}

fun main() {
    printNonNull(null)
    printNonNull(" Kotlin let ")
}