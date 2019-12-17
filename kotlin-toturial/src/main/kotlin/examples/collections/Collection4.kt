package main.kotlin.examples.collections

data class Person(val name: String, val city: String, val phone: String)

val peoples = listOf(
    Person("John", "Boston", "+1-888-123456"),
    Person("Sarah", "Munich", "+49-777-789123"),
    Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
    Person("Vasilisa", "Saint-Petersburg", "+7-999123456")
)

val phoneBook = peoples.associateBy { it.phone }
val cityBook = peoples.associateBy(Person::phone, Person::city)
val peopleCities = peoples.groupBy(Person::city, Person::name)

fun main() {
    associateBy_groupBy()
    fun_partition()
    fun_flatMap()
}

fun associateBy_groupBy() {
    println("******************************** associateBy groupBy ******************************** ")
    println("people: $peoples")
    println("phoneBook:$phoneBook")
    println("cityBook:$cityBook")
    println("peopleCities:$peopleCities")
}

fun fun_partition() {
    println("********************** partition **********************")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers:$numbers")
    // partition 返回Pair
    val evenOdd = numbers.partition { it % 2 == 0 }
    val (positives, negatives) = numbers.partition { it > 0 }
    println("partition:$evenOdd")
    println("partition positives:$positives,\nnegatives:$negatives")
}

// todo
fun fun_flatMap() {
    println("********************** flat map **********************")
    val list = listOf(listOf(10, 20), listOf(30, 40), listOf(50, 60))
    var mapList = list.map { ele -> ele.toString() }
    var flatMapList = list.flatMap { ele -> ele.asIterable() }

    println("mapList:$mapList")
    println("flatMapList:$flatMapList")
}