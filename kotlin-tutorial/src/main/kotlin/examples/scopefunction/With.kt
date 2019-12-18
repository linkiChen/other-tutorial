package main.kotlin.examples.scopefunction

/**
 * 与let run不同,with不是一个扩展函数,let run都是通过 '对象.'的方式
 * 对对象进行函数扩展的,
 * 而with的使用方式则是with(Object),在with代码块中可以使用this代批Object
 */

data class People(val name: String, val age: Int, val gender: String)

fun simplePrint(people: People) {
    with(people) {
        println("people with Print: name=$this.name,age=$age,gender=$gender")
    }
    println("people common print: name=${people.name},age=${people.age},gender=${people.gender}")
}

fun main() {
    val people = People("Jacky", 25, "female")
    simplePrint(people)
}