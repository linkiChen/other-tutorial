package main.kotlin.examples.scopefunction

class Person(var name: String, var age: Int, var gender: String)

val jacky = Person(
    name = "Jacky",
    age = 25,
    gender = "female"
)
val jackyDesc = jacky.apply { println("name is:$name, age is:$age, gender is:$gender") }


val jake = Person("jake", 21, "M").also { println(it.name) }

fun main() {
    println(jackyDesc)
}