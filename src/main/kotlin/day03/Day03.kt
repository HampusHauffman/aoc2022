package day03

import readInput

fun main(args: Array<String>) {

    fun Char.value(): Int {
        return if (this.isLowerCase()) {
            this.code - 96
        } else {
            this.code - 38
        }
    }

    fun part1(input: List<CharArray>): Int {
        var totalSum = 0

        input.forEach lit@{ backPack ->
            val firstComp = firstComp(backPack)
            val secondComp = secondComp(backPack)

            firstComp.forEach {
                if (secondComp.contains(it)) {
                    totalSum += it.value()
                    return@lit
                }
            }
        }
        return totalSum
    }

    fun part2(input: List<CharArray>): Int {

        val groups = input.chunked(3)
        var totalSum = 0

        groups.forEach { group ->
            val groupSet = group.map { it.toSet() }
            groupSet[0].forEach {
                if (groupSet[1].contains(it) && groupSet[2].contains(it)) {
                    totalSum += it.value()
                }
            }

        }

        return totalSum
    }

    val input = readInput("03")
    val pack = input.map { it.toCharArray() }

    println(part1(pack))
    println(part2(pack))
}

private fun firstComp(pack: CharArray) = pack.copyOfRange(0, pack.size / 2)
private fun secondComp(pack: CharArray) = pack.copyOfRange(pack.size / 2, pack.size)
