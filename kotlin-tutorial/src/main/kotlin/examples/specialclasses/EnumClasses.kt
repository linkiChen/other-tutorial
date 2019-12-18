package main.kotlin.examples.specialclasses

/**
 * enum class通过是一个模型类,用来表示 一组有限的不同值
 * 例如：指示,状态,模式等
 */
enum class State {
    IDLE, RUNNING, FINISHED
}

/**
 * 带方法的枚举类,实例与成员(包括方法和变量)之间要有';'分隔开
 *
 * */
enum class Color(val rgb: Int) {
    // 实例需要按构造方法传递参数
    RED(0xFF0000),
    GREEN(0x00ff00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = this.rgb and RED.rgb != 0
}

fun main() {
    val state = State.FINISHED
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    println()
    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
}