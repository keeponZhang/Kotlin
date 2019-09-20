package net.println.kotlin.chapter4.SealedClass

/**
 * Created by benny on 4/4/17.
 */
//密封类是子类有限的类  枚举是实例可数
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0): PlayerCmd()

    class Seek(val position: Long): PlayerCmd()

    object Pause: PlayerCmd()

    object Resume: PlayerCmd()

    object Stop: PlayerCmd()
}

enum class PlayerState{
    IDLE, PAUSE, PLAYING
}


