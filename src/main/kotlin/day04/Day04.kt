package day04

import readInput

fun main(args: Array<String>) {

    fun part1(input: List<String>): Int {
        var totalSum = 0
        input.forEach { pair ->
            val p = pair.split(",")
            val first = p[0].split("-").map { it.toInt() }
            val second = p[1].split("-").map { it.toInt() }

            if ((first[0] <= second[0] && first[1] >= second[1]) || (second[0] <= first[0] && second[1] >= first[1])) totalSum++

        }

        return totalSum
    }

    fun part2(input: List<String>): Int {

        var totalSum = 0

        input.forEach { pair ->
            val p = pair.split(",")
            val first = p[0].split("-").map { it.toInt() }
            val second = p[1].split("-").map { it.toInt() }

            val firstSet = IntRange(first[0], first[1])
            val secondSet = IntRange(second[0], second[1])

            if (firstSet.any { it in secondSet }) totalSum++

        }


        return totalSum
    }

    val input = readInput("04")

    println(part1(input))
    println(part2(input))
}

