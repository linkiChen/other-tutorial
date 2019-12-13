package main.kotlin.examples.controlflow

fun main() {
    println("============================== for loop ==============================")
    for_loop()
    println("============================== while and do-while loop ==============================")
    while_do_while_looop()
    println("============================== iterator loop ==============================")
    iterator_loop()
}

fun for_loop() {
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) println("Yummy,it's a $cake cake!")
}


fun while_do_while_looop() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")


fun iterator_loop() {
    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    println("-------------- iterator while loop --------------")
    var iterator = zoo.iterator()
    while (iterator.hasNext()) {
        println("Watch out,it's a ${iterator.next().name}")
    }
    println("-------------- iterator for loop --------------")
    for (animal in zoo) {
        println("Watch out,it's a ${animal.name}")
    }
}


class Animal(val name: String)

class Zoo(private val animals: List<Animal>) {
    /**
     * 在Zoo为中定义一个iterator迭代器,这个迭代器的名字必须为'iterator'
     * 并且要有operator关键词描述
     */
    operator fun iterator(): Iterator<Animal> = animals.iterator()
}

