package main.kotlin.examples.specialclasses

/**
 * data class是用于存储数据的类，这样的类会默认提供
 * 如copy、toString这样的方法,可以在集合中使用
 * 其实相当于java中的pojo类
 */
data class User(val name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // 拥有相同属性的两个实例,他们的hashCode也是相同的,并且equal也是true
    println("user == secondUser: ${user == secondUser}")
    println("user === secondUser: ${user === secondUser}")
    println("user == thirdUser: ${user == thirdUser}")
    println()
    println("user hashCode: ${user.hashCode()}")
    println("second user hashCode: ${secondUser.hashCode()}")
    println("third user hashCode: ${thirdUser.hashCode()}")

    println()
    // 通过copy得到的都是新的实例，copy方法是data class 类默认提供的
    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 2))
    println()
    println("name = ${user.name}")
    println("id = ${user.id}")
}