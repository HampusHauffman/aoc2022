package day05

import java.util.regex.Pattern

fun main(args: Array<String>) {

    fun stack(): MutableList<String> {
        val stack: MutableList<String> = MutableList(9) { "" }
        stackText.lines().forEach { line ->
            line.mapIndexed { index, c ->
                if (index % 4 == 1 && c != ' ') {
                    stack[index / 4] = stack[index / 4] + c
                }
            }
        }
        return stack.map { it.reversed() }.toMutableList()
    }

    fun pattern(): Pattern {
        return Pattern.compile("-?\\d+")
    }

    fun matcher(it: String) = pattern().matcher(it)

    fun part1(): Int {

        val stack: MutableList<String> = stack()

        println(stack)
        val moves = movesText.lines()
        moves.forEach {
            val m = pattern().matcher(it)
            m.find()
            val amontOfMoves = m.group().toInt() - 1

            m.find()
            val moveFrom = m.group().toInt() - 1
            m.find()
            val moveTo = m.group().toInt() - 1
            for (i in 0..amontOfMoves) {
                val l = stack[moveFrom].last()
                stack[moveFrom] = stack[moveFrom].dropLast(1)
                stack[moveTo] = stack[moveTo] + l
            }
        }
        println(stack)
        stack.forEach { println(it.last()) }
        return 0
    }

    fun part2(): Int {
        println("PART 2")
        val stack: MutableList<String> = stack()
        val p: Pattern = pattern()

        println(stack)
        val moves = movesText.lines()
        moves.forEach {
            val m = matcher(it)
            m.find()
            val amontOfMoves = m.group().toInt()

            m.find()
            val moveFrom = m.group().toInt() - 1
            m.find()
            val moveTo = m.group().toInt() - 1

            val moving = stack[moveFrom].takeLast(amontOfMoves)
            stack[moveFrom] = stack[moveFrom].dropLast(amontOfMoves)
            stack[moveTo] = stack[moveTo] + moving

        }
        println(stack)
        stack.forEach { println(it.last()) }

        return 0
    }


    part1()
    part2()
}

val stackText: String = """
    [S] [C]         [Z]
[F] [J] [P]         [T]     [N]
[G] [H] [G] [Q]     [G]     [D]
[V] [V] [D] [G] [F] [D]     [V]
[R] [B] [F] [N] [N] [Q] [L] [S]
[J] [M] [M] [P] [H] [V] [B] [B] [D]
[L] [P] [H] [D] [L] [F] [D] [J] [L]
[D] [T] [V] [M] [J] [N] [F] [M] [G]
""".trimIndent()

val movesText: String = """
move 3 from 4 to 6
move 1 from 5 to 8
move 3 from 7 to 3
move 4 from 5 to 7
move 1 from 7 to 8
move 3 from 9 to 4
move 2 from 8 to 2
move 4 from 4 to 5
move 2 from 5 to 1
move 2 from 5 to 6
move 7 from 8 to 1
move 9 from 3 to 9
move 11 from 6 to 5
move 2 from 6 to 7
move 12 from 1 to 4
move 10 from 2 to 9
move 2 from 3 to 9
move 1 from 7 to 5
move 4 from 7 to 6
move 2 from 6 to 1
move 5 from 1 to 6
move 10 from 9 to 1
move 9 from 9 to 8
move 13 from 4 to 3
move 7 from 6 to 2
move 2 from 8 to 5
move 9 from 3 to 9
move 8 from 9 to 8
move 4 from 8 to 4
move 1 from 7 to 5
move 3 from 9 to 1
move 7 from 2 to 1
move 1 from 3 to 1
move 1 from 3 to 6
move 1 from 6 to 1
move 2 from 3 to 6
move 5 from 4 to 1
move 1 from 6 to 1
move 3 from 8 to 7
move 8 from 8 to 4
move 3 from 5 to 4
move 1 from 6 to 7
move 1 from 5 to 8
move 4 from 5 to 2
move 7 from 5 to 8
move 3 from 2 to 7
move 7 from 4 to 8
move 11 from 8 to 4
move 15 from 4 to 1
move 25 from 1 to 6
move 4 from 8 to 7
move 1 from 2 to 4
move 11 from 6 to 4
move 12 from 6 to 3
move 1 from 1 to 9
move 1 from 9 to 8
move 16 from 1 to 3
move 1 from 8 to 7
move 12 from 4 to 6
move 9 from 6 to 5
move 3 from 6 to 5
move 6 from 7 to 5
move 3 from 3 to 5
move 2 from 6 to 3
move 11 from 5 to 8
move 2 from 8 to 3
move 2 from 1 to 4
move 7 from 3 to 1
move 2 from 4 to 6
move 2 from 6 to 2
move 5 from 7 to 3
move 1 from 1 to 6
move 1 from 1 to 8
move 2 from 2 to 5
move 1 from 7 to 4
move 1 from 1 to 2
move 10 from 3 to 5
move 11 from 3 to 6
move 1 from 4 to 9
move 1 from 9 to 4
move 1 from 4 to 2
move 2 from 5 to 9
move 2 from 2 to 8
move 2 from 1 to 6
move 2 from 1 to 2
move 2 from 3 to 6
move 3 from 8 to 1
move 3 from 1 to 4
move 7 from 8 to 3
move 2 from 9 to 5
move 2 from 4 to 9
move 7 from 5 to 6
move 2 from 8 to 6
move 1 from 4 to 8
move 2 from 2 to 4
move 21 from 6 to 3
move 10 from 5 to 7
move 7 from 7 to 6
move 1 from 9 to 3
move 1 from 4 to 9
move 1 from 9 to 4
move 1 from 8 to 4
move 8 from 6 to 4
move 1 from 4 to 5
move 1 from 5 to 8
move 4 from 3 to 6
move 1 from 8 to 2
move 1 from 4 to 2
move 2 from 7 to 3
move 2 from 2 to 7
move 22 from 3 to 5
move 4 from 6 to 2
move 2 from 6 to 9
move 7 from 3 to 9
move 6 from 9 to 1
move 18 from 5 to 3
move 2 from 5 to 4
move 20 from 3 to 5
move 3 from 7 to 3
move 5 from 1 to 2
move 11 from 5 to 7
move 1 from 1 to 7
move 3 from 9 to 3
move 16 from 5 to 8
move 7 from 8 to 7
move 1 from 9 to 2
move 8 from 2 to 3
move 2 from 2 to 4
move 3 from 3 to 1
move 9 from 3 to 8
move 1 from 6 to 3
move 9 from 7 to 3
move 3 from 1 to 8
move 1 from 7 to 9
move 1 from 9 to 4
move 1 from 7 to 5
move 10 from 4 to 5
move 2 from 4 to 2
move 19 from 8 to 5
move 1 from 8 to 3
move 4 from 3 to 5
move 2 from 4 to 8
move 4 from 7 to 8
move 4 from 3 to 9
move 4 from 7 to 6
move 2 from 2 to 5
move 2 from 3 to 2
move 6 from 8 to 7
move 1 from 8 to 4
move 2 from 6 to 4
move 3 from 4 to 8
move 3 from 9 to 2
move 4 from 7 to 8
move 28 from 5 to 8
move 16 from 8 to 4
move 11 from 8 to 4
move 3 from 3 to 4
move 7 from 5 to 8
move 13 from 8 to 7
move 1 from 5 to 6
move 1 from 6 to 7
move 1 from 9 to 2
move 2 from 6 to 2
move 12 from 4 to 9
move 4 from 4 to 1
move 2 from 9 to 8
move 4 from 8 to 3
move 3 from 4 to 5
move 4 from 4 to 1
move 4 from 4 to 7
move 3 from 7 to 9
move 5 from 9 to 7
move 7 from 2 to 3
move 1 from 5 to 7
move 8 from 1 to 5
move 1 from 2 to 4
move 11 from 3 to 1
move 10 from 5 to 3
move 3 from 9 to 1
move 3 from 9 to 6
move 5 from 1 to 6
move 7 from 6 to 9
move 8 from 9 to 7
move 9 from 3 to 4
move 1 from 6 to 9
move 8 from 7 to 1
move 9 from 4 to 2
move 2 from 1 to 6
move 3 from 2 to 6
move 4 from 4 to 6
move 2 from 9 to 8
move 2 from 1 to 2
move 1 from 3 to 8
move 2 from 8 to 4
move 1 from 6 to 8
move 11 from 1 to 6
move 1 from 1 to 5
move 3 from 2 to 9
move 2 from 9 to 3
move 1 from 1 to 7
move 2 from 4 to 9
move 4 from 2 to 9
move 2 from 8 to 5
move 10 from 6 to 1
move 2 from 5 to 6
move 5 from 9 to 8
move 5 from 8 to 7
move 1 from 2 to 1
move 7 from 1 to 2
move 2 from 9 to 4
move 1 from 3 to 5
move 15 from 7 to 2
move 8 from 6 to 3
move 2 from 4 to 3
move 2 from 6 to 4
move 4 from 7 to 1
move 4 from 7 to 5
move 1 from 6 to 4
move 3 from 1 to 7
move 5 from 7 to 6
move 4 from 7 to 5
move 18 from 2 to 4
move 5 from 6 to 4
move 4 from 1 to 2
move 8 from 3 to 8
move 2 from 8 to 4
move 2 from 3 to 7
move 1 from 5 to 7
move 3 from 8 to 4
move 2 from 7 to 2
move 1 from 3 to 8
move 9 from 2 to 6
move 2 from 8 to 6
move 1 from 7 to 3
move 1 from 3 to 5
move 3 from 6 to 8
move 1 from 8 to 5
move 1 from 5 to 9
move 1 from 1 to 2
move 5 from 4 to 6
move 10 from 6 to 2
move 5 from 2 to 6
move 5 from 6 to 4
move 1 from 6 to 3
move 6 from 4 to 6
move 3 from 2 to 6
move 2 from 2 to 3
move 11 from 4 to 6
move 1 from 9 to 5
move 4 from 6 to 7
move 1 from 4 to 3
move 12 from 4 to 3
move 1 from 8 to 6
move 9 from 5 to 7
move 1 from 5 to 2
move 1 from 8 to 5
move 1 from 4 to 9
move 9 from 7 to 9
move 1 from 3 to 4
move 2 from 3 to 6
move 2 from 5 to 6
move 2 from 8 to 5
move 11 from 3 to 4
move 2 from 3 to 1
move 1 from 2 to 3
move 1 from 3 to 8
move 3 from 7 to 9
move 5 from 4 to 2
move 2 from 5 to 8
move 6 from 4 to 2
move 1 from 1 to 3
move 12 from 9 to 1
move 6 from 1 to 6
move 1 from 8 to 4
move 1 from 8 to 3
move 5 from 2 to 7
move 2 from 3 to 9
move 5 from 7 to 1
move 1 from 7 to 5
move 2 from 9 to 1
move 14 from 1 to 7
move 2 from 4 to 7
move 7 from 2 to 4
move 1 from 2 to 1
move 1 from 1 to 3
move 1 from 5 to 4
move 1 from 9 to 6
move 16 from 6 to 5
move 2 from 5 to 4
move 12 from 6 to 8
move 10 from 4 to 8
move 9 from 7 to 3
move 4 from 7 to 6
move 11 from 5 to 8
move 2 from 5 to 2
move 14 from 8 to 9
move 1 from 5 to 1
move 3 from 9 to 4
move 2 from 2 to 1
move 7 from 8 to 3
move 6 from 3 to 5
move 8 from 9 to 8
move 1 from 6 to 1
move 1 from 4 to 2
move 4 from 3 to 8
move 1 from 7 to 2
move 3 from 1 to 5
move 2 from 5 to 7
move 3 from 9 to 2
move 1 from 1 to 8
move 5 from 5 to 4
move 2 from 7 to 8
move 4 from 2 to 5
move 1 from 2 to 4
move 2 from 7 to 8
move 4 from 6 to 2
move 6 from 5 to 3
move 1 from 6 to 5
move 1 from 5 to 3
move 1 from 3 to 8
move 8 from 8 to 3
move 9 from 8 to 5
move 9 from 8 to 2
move 2 from 8 to 9
move 2 from 3 to 8
move 5 from 5 to 8
move 1 from 3 to 7
move 2 from 9 to 5
move 7 from 2 to 4
move 14 from 4 to 6
move 2 from 2 to 7
move 1 from 7 to 3
move 1 from 7 to 9
move 3 from 5 to 2
move 1 from 7 to 1
move 3 from 2 to 4
move 7 from 8 to 2
move 3 from 6 to 1
move 17 from 3 to 1
move 2 from 8 to 3
move 6 from 2 to 7
move 2 from 7 to 9
move 3 from 6 to 8
move 2 from 8 to 6
move 4 from 2 to 1
move 3 from 4 to 7
move 1 from 8 to 7
move 1 from 8 to 9
move 1 from 4 to 2
move 3 from 5 to 7
move 2 from 3 to 1
move 2 from 3 to 5
move 5 from 7 to 4
move 5 from 7 to 3
move 1 from 4 to 8
move 3 from 3 to 1
move 6 from 1 to 3
move 1 from 7 to 5
move 2 from 9 to 2
move 3 from 5 to 8
move 1 from 8 to 1
move 8 from 3 to 5
move 1 from 4 to 9
move 3 from 6 to 5
move 3 from 6 to 3
move 2 from 3 to 7
move 1 from 4 to 7
move 3 from 6 to 4
move 2 from 7 to 2
move 1 from 7 to 8
move 2 from 5 to 4
move 1 from 6 to 1
move 7 from 4 to 7
move 7 from 5 to 2
move 10 from 2 to 3
move 3 from 2 to 6
move 3 from 8 to 1
move 1 from 8 to 7
move 2 from 6 to 3
move 1 from 6 to 9
move 4 from 7 to 5
move 16 from 1 to 5
move 1 from 9 to 7
move 3 from 7 to 6
move 11 from 5 to 6
move 2 from 7 to 9
move 12 from 6 to 4
move 2 from 6 to 9
move 6 from 3 to 2
move 1 from 5 to 7
move 5 from 9 to 5
move 1 from 9 to 6
move 4 from 3 to 7
move 1 from 4 to 2
move 7 from 2 to 5
move 3 from 5 to 2
move 6 from 5 to 6
move 3 from 2 to 6
move 9 from 6 to 8
move 5 from 5 to 9
move 5 from 7 to 1
move 4 from 1 to 9
move 2 from 9 to 4
move 1 from 6 to 7
move 9 from 4 to 1
move 7 from 5 to 9
move 18 from 1 to 3
move 9 from 9 to 5
move 8 from 8 to 2
move 1 from 2 to 5
move 4 from 2 to 3
move 4 from 9 to 6
move 1 from 4 to 8
move 2 from 5 to 7
move 2 from 9 to 2
move 10 from 3 to 9
move 5 from 5 to 9
move 1 from 7 to 2
move 2 from 8 to 7
move 2 from 3 to 5
move 2 from 9 to 1
move 2 from 7 to 3
move 1 from 2 to 1
move 5 from 5 to 8
move 1 from 2 to 1
move 15 from 3 to 6
move 1 from 7 to 6
move 10 from 6 to 5
move 1 from 7 to 8
move 4 from 1 to 6
move 1 from 8 to 3
move 2 from 1 to 5
move 3 from 8 to 1
move 1 from 4 to 6
move 1 from 4 to 2
move 4 from 9 to 7
move 6 from 5 to 7
move 3 from 1 to 9
move 10 from 6 to 8
move 2 from 1 to 3
move 8 from 7 to 9
move 1 from 9 to 6
move 2 from 7 to 9
move 3 from 3 to 5
move 1 from 2 to 6
move 2 from 6 to 5
move 5 from 9 to 4
move 4 from 8 to 2
move 1 from 1 to 3
move 4 from 5 to 9
move 3 from 6 to 1
move 2 from 1 to 5
move 3 from 5 to 2
move 8 from 8 to 3
move 11 from 9 to 4
move 13 from 4 to 8
move 2 from 9 to 2
move 2 from 3 to 1
move 1 from 4 to 1
move 1 from 3 to 8
move 2 from 6 to 9
move 7 from 8 to 1
move 3 from 2 to 5
move 7 from 2 to 5
move 3 from 4 to 6
move 4 from 9 to 2
move 2 from 3 to 5
move 9 from 5 to 6
move 5 from 2 to 7
move 2 from 9 to 2
move 2 from 9 to 7
move 12 from 6 to 8
move 5 from 5 to 7
move 1 from 9 to 8
move 3 from 1 to 6
move 5 from 5 to 8
move 6 from 1 to 9
move 2 from 1 to 5
move 1 from 6 to 9
move 5 from 9 to 7
move 2 from 5 to 8
move 11 from 7 to 6
move 20 from 8 to 1
move 2 from 9 to 8
move 4 from 7 to 6
move 6 from 8 to 3
move 13 from 6 to 9
move 4 from 3 to 2
move 4 from 6 to 3
move 2 from 3 to 6
move 5 from 9 to 8
move 2 from 7 to 1
move 2 from 6 to 9
move 6 from 8 to 3
move 6 from 3 to 6
move 5 from 2 to 9
move 22 from 1 to 3
move 3 from 2 to 1
move 5 from 9 to 3
move 1 from 1 to 6
move 3 from 6 to 2
move 1 from 2 to 4
move 33 from 3 to 5
move 1 from 8 to 7
""".trimIndent()

