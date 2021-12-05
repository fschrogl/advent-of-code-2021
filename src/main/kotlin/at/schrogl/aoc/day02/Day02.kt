package at.schrogl.aoc.day02

class Day02 {

    fun readInput(filename: String) = Day02::class.java.getResource(filename)
        ?.readText()
        ?.lines()
        ?.filter { it.isNotEmpty() }
        ?: throw NullPointerException("Input file not found: $filename")

    class Submarine(var horizontal: Int, var depth: Int, var aim: Int) {

        fun computeCommand1(cmd: String) {
            when {
                cmd.startsWith("forward") -> horizontal += cmd.substringAfterLast(' ').toInt()
                cmd.startsWith("up") -> depth -= cmd.substringAfterLast(' ').toInt()
                cmd.startsWith("down") -> depth += cmd.substringAfterLast(' ').toInt()
                else -> println("Unknown command: $cmd")
            }
        }

        fun computeCommand2(cmd: String) {
            when {
                cmd.startsWith("forward") -> {
                    horizontal += cmd.substringAfterLast(' ').toInt()
                    depth += aim * cmd.substringAfterLast(' ').toInt()
                }
                cmd.startsWith("up") -> aim -= cmd.substringAfterLast(' ').toInt()
                cmd.startsWith("down") -> aim += cmd.substringAfterLast(' ').toInt()
                else -> println("Unknown command: $cmd")
            }
        }
    }
}

fun List<String>.solution1(): Int {
    val submarine = Day02.Submarine(0, 0, 0)
    forEach(submarine::computeCommand1)
    return submarine.horizontal * submarine.depth
}

fun List<String>.solution2(): Int {
    val submarine = Day02.Submarine(0, 0, 0)
    forEach(submarine::computeCommand2)
    return submarine.horizontal * submarine.depth
}

fun main() {
    println(
        """
        Day 2-1
            test1 = ${Day02().readInput("input-test.txt").solution1()} (expected: 150)
            ex1   = ${Day02().readInput("input.txt").solution1()}
            
        Day 2-2
            test1 = ${Day02().readInput("input-test.txt").solution2()} (expected: 900)
            ex1   = ${Day02().readInput("input.txt").solution2()}
    """.trimIndent()
    )
}
