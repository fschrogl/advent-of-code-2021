package at.schrogl.aoc.day03

class Day03 {

    fun readInput(filename: String) = Day03::class.java.getResource(filename)
        ?.readText()
        ?.lines()
        ?.filter { it.isNotEmpty() }
        ?: throw NullPointerException("Input file not found")

}

fun List<String>.solution1(): Int {
    val ones = IntArray(get(0).length)
    val zeros = IntArray(get(0).length)

    forEach {
        for ((index, c) in it.withIndex()) {
            when (c) {
                '1' -> ones[index]++
                else -> zeros[index]++
            }
        }
    }

    var gamma = ""
    var epsilon = ""
    for (i in ones.indices)
        if (ones[i] > zeros[i]) {
            gamma += "1"
            epsilon += "0"
        } else {
            gamma += "0"
            epsilon += "1"
        }

    return gamma.toInt(2) * epsilon.toInt(2)
}

fun main() {
    println(
        """
        Day 3-1
            test1 = ${Day03().readInput("input-test.txt").solution1()} (expected: 198)
            ex1   = ${Day03().readInput("input.txt").solution1()}
    """.trimIndent()
    )
}
