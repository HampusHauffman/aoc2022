package day07

import readInput

fun main(args: Array<String>) {

    fun part1() {
        val commands = readInput("07").toMutableList()

        val current: MutableList<String> = mutableListOf("/")
        val dirs: MutableMap<String, Int> = mutableMapOf("/" to 0)

        commands.forEach {
            when {
                it.contains("$ cd ..") -> {
                    current.removeLast()
                }
                it.contains("$ cd") -> {
                    current.add(it.split(" ")[2])
                }
                it.contains("ls") -> {
                }
                it.contains("dir") -> {
                }
                else -> {
                    var d = ""
                    current.forEachIndexed { index, s ->
                        d += s
                        dirs[d] = (dirs[d] ?: 0) + it.split(" ")[0].toInt()
                    }
                    println(d)
                }
            }
        }
        println(dirs.filter { it.value <= 100000 }.map { it.value }.sum())

        println((dirs["/"]!!))
        //println(dirs.filter {  it.value >= 30000000 - (70000000 - dirs["/"]!!) }.toList().sortedBy { (_, value) -> value }[0])
    }
    part1()


    fun part2() {
    }
    part2()
}
//40272162
//40532950
