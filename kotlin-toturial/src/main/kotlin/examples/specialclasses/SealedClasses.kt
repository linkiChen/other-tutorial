package main.kotlin.examples.specialclasses

/**
 * sealed class(密封类)会限制你对继承的使用,一旦声明了一个sealed class
 * 在当前文件之外的地址都不可创建它的子类
 */
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    return when (mammal) {
        // 这里除了会判断mammal是不是Human实例外,在mammal是Human实例的情况下还会将mammal转换为Human
        is Human -> "Hello ${mammal.name};You're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.catName}"
        // 一般情况下when会结合else作一个默认处理(也即以上的情况都不会出现的时候的处理)，但这里
        // 不需要else是因为已经明确知道了Mammal的子类只有Human和Cat这两个,所有的情况已经作了处理
        // 就不需要else了
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}