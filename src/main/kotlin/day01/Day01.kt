package day01

import readInput

fun main(args: Array<String>) {

    fun part1(input: List<String>): Int {

        // An elf is a Mutable list and this is a list of elfs
        val elfs: MutableList<MutableList<Int>> = mutableListOf()

        elfs.add(mutableListOf());

        input.forEach {
            // Add an elf if blank line
            if (it.isBlank()) {
                elfs.add(mutableListOf());
            } else {
                elfs.last().add(it.toInt());
            }

        }

         elfs.sortBy { it.sum() }

        return elfs.last().sum()
    }

    fun part2(input: List<String>): Int {
        // An elf is a Mutable list and this is a list of elfs
        val elfs: MutableList<MutableList<Int>> = mutableListOf()

        elfs.add(mutableListOf());

        input.forEach {
            // Add an elf if blank line
            if (it.isBlank()) {
                elfs.add(mutableListOf());
            } else {
                elfs.last().add(it.toInt());
            }

        }

        elfs.sortBy { -it.sum() }

        return elfs[0].sum()+elfs[1].sum()+elfs[2].sum()
    }

    val input = readInput("01")
    println(part1(input))
    println(part2(input))
}
