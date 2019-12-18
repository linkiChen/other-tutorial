package main.kotlin.examples.delegatoin

interface SoundBehavior {
    fun makeSound()
}

// ScreamBehavior RockAndRollBehavior都实现了SoundBehavior接口并实现了makeSound方法
class ScreamBehavior(val n: String) : SoundBehavior {
    override fun makeSound() {
        println("${n.toUpperCase()} !!!")
    }
}

class RockAndRollBehavior(val n: String) : SoundBehavior {
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

// TomAraya ElvisPresley都实现了SoundBehavior接口,但是并没有实现makeSound方法,
// 而是通过委托将方法的实现委托到相应的委托对象的实现上
// 委托对象通过by关键词声明
class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)

fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()

    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()
}