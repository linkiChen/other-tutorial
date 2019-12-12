package main.kotlin.examples.introductions

/**
 * Kotlin中的类包含：
 * 类名(name)
 * 头部(header): 包含参数及其类型、主要的构造方法
 * 类的内容(body): 类的内容包含在'{'、'}'中
 * 在没有类内容及参数时,可以只包含类名
 *
 */
class Customer

class Contact(val id: Int, var email: String)

class Buildings(val height: Double, var name: String) {
    fun printNameAndHeight() {
        println("This building's name=${this.name},and height=${this.height}")
    }
}

fun main() {
    val customer = Customer()

    val contact = Contact(1, "jacky@gmail.com")

    println(contact.id)
    contact.email = "jacky@163.com"

    println(contact.email)

    val building = Buildings(100.5, "Glaxy")
    building.printNameAndHeight()
}