package day08

import readInput

fun main1(args: Array<String>) {

    val l = mutableListOf<MutableList<Int>>()
    readInput("08").forEachIndexed { row, s ->
        l.add(mutableListOf())
        s.forEachIndexed { col, c -> l[row].add(c.code - 48) }
    }


    fun checkDir(row: Int, col: Int, rowM: Int, colM: Int, rowC: Int, colC: Int): Boolean {
        if (row == 0 || row == l.size - 1 || col == 0 || col == l.size - 1) return true
        if (rowM < 0 || rowM > l.size - 1 || colM < 0 || colM > l.size - 1) return true
        if (l[row][col] <= l[rowM][colM]) return false
        return checkDir(row, col, rowM + rowC, colM + colC, rowC, colC)
    }

    fun checkDirWrapper(row: Int, col: Int): Boolean {
        return checkDir(row, col, row - 1, col, -1, 0) ||
            checkDir(row, col, row, col - 1, 0, -1) ||
            checkDir(row, col, row + 1, col, 1, 0) ||
            checkDir(row, col, row, col + 1, 0, 1)
    }

    var c = 0;

    l.forEachIndexed { row, _it ->
        _it.forEachIndexed { col, i ->
            if (checkDirWrapper(row, col)) {
                println(l[row][col])
                c++
            }

        }
    }
    println(c)
}

fun main(args: Array<String>) {

    val l = mutableListOf<MutableList<Int>>()
    readInput("08").forEachIndexed { row, s ->
        l.add(mutableListOf())
        s.forEachIndexed { col, c -> l[row].add(c.code - 48) }
    }


    fun checkDir(row: Int, col: Int, rowM: Int, colM: Int, rowC: Int, colC: Int, trees: Int): Int {
        if (rowM < 0 || rowM > l.size - 1 || colM < 0 || colM > l.size - 1) return trees
        if (l[row][col] > l[rowM][colM]) {
            return checkDir(row, col, rowM + rowC, colM + colC, rowC, colC, trees) + 1
        } else {
            return trees + 1
        }
    }

    fun checkDirWrapper(row: Int, col: Int): Int {
        return checkDir(row, col, row - 1, col, -1, 0, 0) *
            checkDir(row, col, row, col - 1, 0, -1, 0) *
            checkDir(row, col, row + 1, col, 1, 0, 0) *
            checkDir(row, col, row, col + 1, 0, 1, 0)
    }

    var s = 0;

    l.forEachIndexed { row, _it ->
        _it.forEachIndexed { col, i ->
            val si = checkDirWrapper(row, col)
            if (si > s) {
                println("row: $row col: $col")
                s = si
            }

        }
    }
    println(s)
}



