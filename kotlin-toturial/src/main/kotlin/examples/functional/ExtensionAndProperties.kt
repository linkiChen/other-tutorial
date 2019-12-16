package main.kotlin.examples.functional

/**
 * Kotlin允许通过扩展机制给任何类添加成员(包括方法和属性)
 * Kotlin中有两个扩展机制,一种是扩展类的成员方法,另一种就是
 * 扩展类的属性,见下例
 */

// 定义两个简单的数据模型Item、Order
data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

// 给Order添加两个扩展函数maxPricedItemValue、maxPricedItemName
fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F

fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"

// 给Order添加一个扩展属性commaDelimitedItemNames
val Order.commaDelimitedItemNames: String get() = items.map { it.name }.joinToString()


fun main() {
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")

    println("Max priced item value: ${order.maxPricedItemValue()}")

    println("Items: ${order.commaDelimitedItemNames}")
}