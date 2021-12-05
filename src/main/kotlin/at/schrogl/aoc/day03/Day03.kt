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

fun List<String>.solution2(): Int {
    var lifeSupportRating = ""
    for (i in 0 until this[0].length) lifeSupportRating += getMostCommonChar(lifeSupportRating, i)


    var co2ScrubberRating = ""
    for (i in 0 until this[0].length) co2ScrubberRating += getLeastCommonChar(co2ScrubberRating, i)

    return lifeSupportRating.toInt(2) * co2ScrubberRating.toInt(2)
}

fun List<String>.getMostCommonChar(prefix: String, pos: Int): String {
    val filteredList = filter { prefix.isEmpty() || it.startsWith(prefix) }
    val ones = filteredList.count { it[pos] == '1' }
    return if (filteredList.size == 1) filteredList[0][pos].toString() else if (ones >= filteredList.size - ones) "1" else "0"
}

fun List<String>.getLeastCommonChar(prefix: String, pos: Int): String {
    val filteredList = filter { prefix.isEmpty() || it.startsWith(prefix) }
    val ones = filteredList.count { it[pos] == '1' }
    return if (filteredList.size == 1) filteredList[0][pos].toString() else if (ones < filteredList.size - ones) "1" else "0"
}

fun main() {
    println(
        """
        Day 3-1
            test1 = ${Day03().readInput("input-test.txt").solution1()} (expected: 198)
            ex1   = ${Day03().readInput("input.txt").solution1()}
            
        Day 3-2
            test1 = ${Day03().readInput("input-test.txt").solution2()} (expected: 230)
            ex2   = ${Day03().readInput("input.txt").solution2()}
    """.trimIndent()
    )
}
