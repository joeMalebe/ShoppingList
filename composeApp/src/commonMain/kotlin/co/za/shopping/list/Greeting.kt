package co.za.shopping.list

import kotlin.random.Random

class Greeting {
    private val platform = getPlatform()

    fun greet() = buildList {
        add(if (Random.nextBoolean()) "Hi!" else "Hello!")
        add("Guess what this is! > ${platform.name.reversed()}!")
    }
}