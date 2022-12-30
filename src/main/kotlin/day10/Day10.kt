package day10

import readInput

fun main1() {

    var x = 1
    var i = 1
    var t = 0

    val input = readInput("10").map { it.split(" ") }

    fun cycle(c: Int = 1) {
        for (j in 0 until c) {
            if ((i - 20) % 40 == 0) {
                t += i * x
                println(t)
            }
            i++
        }
    }

    input.forEach l@{ c ->
        if (c.size == 1) {
            cycle()
        } else {
            cycle(2)
            x += c[1].toInt()
        }
    }

    println()
    println(i)
    println(x)
}

fun main() {

    var x = 1
    var i = 0
    var t = 0
    var txt: MutableList<MutableList<Char>> = List(6) { (List(40) { '.' }.toMutableList()) }.toMutableList()

    val input = readInput("10").map { it.split(" ") }

    fun cycle(c: Int = 1) {
        for (j in 0 until c) {
            println(x)
            //println("row: ${i / 40}, col: ${i % 40}")
            if (x == i%40 || x - 1 == i%40 || x + 1 == i%40) {
                txt[i/40][i%40] = '#'
            }
            i++
        }
    }

    input.forEach l@{ c ->
        if (c.size == 1) {
            cycle()
        } else {
            cycle(2)
            x += c[1].toInt()
        }
    }

    println()
    println(i)
    println(x)
    txt.forEach {
        println(it)
    }
}

