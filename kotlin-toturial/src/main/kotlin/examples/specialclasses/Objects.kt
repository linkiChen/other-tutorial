package main.kotlin.examples.specialclasses

import java.util.Random

/**
 * 和大多数面向对象语言一样，Kotlin也有Class和Object,
 * class(类)就是拥有共同属性和行为的对象的抽象描述(蓝图)
 * 而(object)对象则是这些描述的具体化，通常我们会定义一个类
 * 然后以这个类作为原料创造很多的实例(对象)
 */

class LuckDispatcher {  // 定义一个类
    fun getNumber() {   // 定义这个的行为
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

fun clazz() {
    val ld1 = LuckDispatcher()
    val ld2 = LuckDispatcher()

    ld1.getNumber()
    ld2.getNumber()
}

/**
 * 在Kotlin中也有object关键字,它用于通过单个实现获取数据类型
 * 其实就是JAVA中的单例,保证只有一个实例,在Kotlin中object是没有
 * 类,没有构造方法,懒加载的
 */

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) {

    // 这里创建的object就像是java中的内部类一样
    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    // 可以在这个函数内直接访问其属性
    val total = dayRates.standard + dayRates.festivity + dayRates.special

    println("Total price: $$total")
}

object DoAuth {
    fun takeParams(userName: String, password: String) {
        println("input Auth parameters = $userName:$password")
    }
}

class BigBen {
    // 伴生对象,相当于java中的静态方法,伴生对象中的属性
    // 方法可以通过伴生类直接访问,伴生对象最后是在包级别下使用
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }

        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}

fun main() {

    clazz()

    rentPrice(3, 4, 5)

    DoAuth.takeParams("admin", "jacky")

    BigBen.getBongs(3)
}

