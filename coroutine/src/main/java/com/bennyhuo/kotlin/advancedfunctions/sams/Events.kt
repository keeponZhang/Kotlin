package com.bennyhuo.kotlin.advancedfunctions.sams

fun main() {
    val eventManager = EventManager()

    //这种写法没问题
    val onEvent = object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    }

    val onEvent2 = EventManager.OnEventListener {
        println("onEvent $it")
    }

    // DO NOT use this.
//    val onEvent3 = { event: Int ->
//        println("onEvent $event")
//    }

    eventManager.addOnEventListener(onEvent)
    //这种写法remove的时候会有问题
//    eventManager.addOnEventListener {
//        println("onEvent $it")
//    }

    eventManager.removeOnEventListener(onEvent)
}