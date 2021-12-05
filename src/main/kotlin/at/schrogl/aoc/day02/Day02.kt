package at.schrogl.aoc.day02

class Day02 {

    fun readInput(filename: String) = Day02::class.java.getResource(filename)
        ?.readText()
        ?.lines()
        ?.filter { it.isNotEmpty() }
        ?: throw NullPointerException("Input file not found: $filename")

    class Submarine(var horizontal: Int, var vertical: Int) {

        fun computeCommand(cmd: String) {
            when {
                cmd.startsWith("forward") -> horizontal += cmd.substringAfterLast(' ').toInt()
                cmd.startsWith("up") -> vertical -= cmd.substringAfterLast(' ').toInt()
                cmd.startsWith("down") -> vertical += cmd.substringAfterLast(' ').toInt()
                else -> println("Unknown command: $cmd")
            }
        }
    }
}

fun List<String>.solution1(): Int {
    val submarine = Day02.Submarine(0, 0)
    forEach(submarine::computeCommand)
    return submarine.horizontal * submarine.vertical
}

fun main() {
    println(
        """
        Day 2-1
            test1 = ${Day02().readInput("input-test.txt").solution1()} (expected: 150)
            ex1   = ${Day02().readInput("input.txt").solution1()}
    """.trimIndent()
    )
}
