package day02

import readInput

fun main(args: Array<String>) {

    fun letterToScore(char: Char): Int {
        return when (char) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> throw Exception("No map for $char")
        }
    }

    fun matchToScore(elf: Char, you: Char): Int {
        val elfInt = elf.code - 65
        val youInt = you.code - 65 - 23
        if (elfInt == youInt) return 3
        return if (youInt == (elfInt + 1) % 3) 6 else 0
    }

    fun whatIShouldPlay(elf: Char, win: Char): Char {
        if (win == 'Y') {
            return (elf.code + 23).toChar()
        }
        return when (elf) {
            'A' -> {
                if (win == 'X') return 'Z'
                else return 'Y'
            }
            'B' -> {
                if (win == 'X') return 'X'
                else return 'Z'
            }
            'C' -> {
                if (win == 'X') return 'Y'
                else return 'X'
            }
            else -> {
                throw Exception("nothing for this")
            }
        }
    }

    fun part1(input: List<String>): Int {
        var totalScore = 0

        input.forEach {
            totalScore += letterToScore(it[2])
            totalScore += matchToScore(it[0], it[2])
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0

        input.forEach {
            val myPlay = whatIShouldPlay(it[0], it[2])
            totalScore += letterToScore(myPlay)
            totalScore += matchToScore(it[0], myPlay)
        }
        return totalScore
    }

    val input = readInput("02")
    println(part1(input))
    println(part2(input))
}
