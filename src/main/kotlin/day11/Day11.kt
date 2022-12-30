package day11

class M(
    var items: MutableList<Int>,
    val op: (Int) -> Int,
    val test: (Int) -> Boolean,
    val tTrue: Int,
    val tFalse: Int,
    var inspected: Int = 0,
) {

    fun act(monkeyList: MutableList<M>) {
        items.forEachIndexed { _, it ->
            val item = op(it) // op(it) / 3 for part 1
            inspected++
            if (test(item)) {
                monkeyList[tTrue].items.add(item)
            } else {
                monkeyList[tFalse].items.add(item)
            }
        }
        items = mutableListOf()
    }

    override fun toString(): String {
        return "$inspected"
    }
}

fun main() {
    val m = mutableListOf<M>()


    setupM(m)

    for (j in 0 until 10000) {
        m.forEach {
            it.act(m)
        }
    }

    println(m)
    val sorted = m.sortedBy { it.inspected }
    println(sorted)
}

private fun setupM(m: MutableList<M>) {
    m.add(M(
        items = mutableListOf(54, 61, 97, 63, 74),
        op = { it * 7 },
        test = { it % 17 == 0 },
        tTrue = 5,
        tFalse = 3,
    ))

    m.add(M(
        items = mutableListOf(61, 70, 97, 64, 99, 83, 52, 87),
        op = { it + 8 },
        test = { it % 2 == 0 },
        tTrue = 7,
        tFalse = 6,
    ))

    m.add(M(
        items = mutableListOf(60, 67, 80, 65),
        op = { it * 13 },
        test = { it % 5 == 0 },
        tTrue = 1,
        tFalse = 6,
    ))

    m.add(M(
        items = mutableListOf(61, 70, 76, 69, 82, 56),
        op = { it + 7 },
        test = { it % 3 == 0 },
        tTrue = 5,
        tFalse = 2,
    ))

    m.add(M(
        items = mutableListOf(79, 98),
        op = { it + 2 },
        test = { it % 7 == 0 },
        tTrue = 0,
        tFalse = 3,
    ))

    m.add(M(
        items = mutableListOf(72, 79, 55),
        op = { it + 1 },
        test = { it % 13 == 0 },
        tTrue = 2,
        tFalse = 1,
    ))

    m.add(M(
        items = mutableListOf(63),
        op = { it + 4 },
        test = { it % 19 == 0 },
        tTrue = 7,
        tFalse = 4,
    ))

    m.add(M(
        items = mutableListOf(72, 51, 93, 63, 80, 86, 81),
        op = { it * it },
        test = { it % 11 == 0 },
        tTrue = 0,
        tFalse = 4,
    ))
}
