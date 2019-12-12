package main.kotlin.examples.introductions

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * 泛型
 */

/**
 * 定义一个参数类型为泛型的类 MutableStack
 */
class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    // 生成MutableStack实例时的类型E为什么类型,则添加元素时就为什么类型
    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty(): Boolean = elements.size == 0

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()}})"
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    val stack = mutableStackOf(0.36, 1.56, 7.89)
    println(stack)
    println(stack.peek())
    println(stack.push(5.694))
    println(stack.isEmpty())
    println(stack)
}