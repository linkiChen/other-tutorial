package main.kotlin.examples.introductions


/**
 * kotlin是完全支持传统的面向对象的继承机制的
 * 需要注意的是,Kotlin中的类及其方法都是final类型的
 * 也就是不可被继承(类)或覆盖(方法)的,如果要使类可以
 * 被继承、方法可以被覆盖,都需要使用open关键字作前缀声明
 */

// Dog类可以被继承
open class Dog {
    // sayHello方法可以被子类覆盖
    open fun sayHello() =
        println("Dog--> wow wow!")
}

/**
 * 类的继承表达式为: class SubClassName : SuperClassName()
 * () 表明实例化子类时会调用父类的默认构造方法
 */

class Yorkshire : Dog() {
    override fun sayHello() {
        println("Yorkshire--> wif wif!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() = println("A tiger form $origin says: grhhh!")
}

// 调用父类的一个参数的构造方法
class SiberianTiger : Tiger("Siberia")


open class Lion(val name: String, val origin: String) {
    fun sayHello() = "$name,the lion form $origin says: graoh !"
}

/**
 * Asiatic 中的name既不是var类型的也不是val类型的
 * 它是一个构造函数参数,其值会传递给父类的name
 *
 */
class Asiatic(name: String) : Lion(name = name, origin = "India")

fun main() {
    val dog = Yorkshire()
    dog.sayHello()

    val tiger = SiberianTiger()
    tiger.sayHello()

    val lion = Asiatic("Rufo")
    lion.sayHello()
}