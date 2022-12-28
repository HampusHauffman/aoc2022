import kotlin.math.absoluteValue
import kotlin.math.sign

fun main2() {
    val l = readInput("09")

    val visited: MutableSet<Pair<Int, Int>> = mutableSetOf(0 to 0)

    var h: Pair<Int, Int> = 0 to 0
    var hLast: Pair<Int, Int> = 0 to 0
    var t: Pair<Int, Int> = 0 to 0

    fun getUpdatedPos(dir: String, pos: Pair<Int, Int>): Pair<Int, Int> {
        return when (dir) {
            "U" -> pos.first - 1 to pos.second
            "D" -> pos.first + 1 to pos.second
            "L" -> pos.first to pos.second - 1
            "R" -> pos.first to pos.second + 1
            else -> throw Exception("No idea where to move")
        }
    }

    fun move(dir: String) {
        // Move H
        hLast = h;
        h = getUpdatedPos(dir, h)

        println("h: $h ")
        // Check if T needs to move
        if ((t.first - h.first).absoluteValue > 1 || (t.second - h.second).absoluteValue > 1) {
            t = hLast
        }
        visited.add(t)
        // Move T and Update visited
    }

    l.forEach { s ->
        val dir = s.split(" ")[0]
        val moves = s.split(" ")[1].toInt()

        println("Moving $dir $moves moves")
        for (i in 0..moves - 1) {
            move(dir)
        }

    }
    println(visited.size)
}

fun main() {
    val l = readInput("09")

    val visited: MutableSet<Pair<Int, Int>> = mutableSetOf(0 to 0)

    var t: MutableList<Pair<Int, Int>> =
        mutableListOf(0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0, 0 to 0)

    fun getUpdatedPos(dir: String, pos: Pair<Int, Int>): Pair<Int, Int> {
        return when (dir) {
            "U" -> pos.first - 1 to pos.second
            "D" -> pos.first + 1 to pos.second
            "L" -> pos.first to pos.second - 1
            "R" -> pos.first to pos.second + 1
            else -> throw Exception("No idea where to move")
        }
    }

    fun move(dir: String) {
        // Move H
        t[0] = getUpdatedPos(dir, t[0])

        // Check if T needs to move
        t.forEachIndexed { i, s ->

            if (i != 0) {
                val rowDif = t[i - 1].first - t[i].first
                val colDif = t[i - 1].second - t[i].second

                if (rowDif.absoluteValue + colDif.absoluteValue > 2) {
                    t[i] = t[i].first to t[i].second + colDif.sign
                    t[i] = t[i].first + rowDif.sign to t[i].second
                } else if (rowDif.absoluteValue > 1) {
                    t[i] = t[i].first + rowDif.sign to t[i].second
                } else if (colDif.absoluteValue > 1) {
                    t[i] = t[i].first to t[i].second + colDif.sign
                }
            }
            visited.add(t[9])
        }
    }

// Move T and Update visited

    l.forEach { s ->
        val dir = s.split(" ")[0]
        val moves = s.split(" ")[1].toInt()

        println("Moving $dir $moves moves")
        for (i in 0..moves - 1) {
            move(dir)
        }
    }
    println(visited.size)
    println(t)
}
//2478
