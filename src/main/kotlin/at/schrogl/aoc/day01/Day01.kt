/*-
 * #%L
 * Advent-Of-Code 2021
 * %%
 * Copyright (C) 2021 Fritz Schrogl
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package at.schrogl.aoc.day01

class Day01 {

    fun readInput(filename: String) = Day01::class.java.getResource(filename)
        ?.readText()
        ?.lines()
        ?.filter { it.isNotEmpty() }
        ?.map { it.toInt() }
        ?: throw NullPointerException("Input file not found")
}

fun List<Int>.solution1(): Int {
    var counter = 0
    for (i in 1 until size) counter += if (this[i - 1] < this[i]) 1 else 0
    return counter
}

fun List<Int>.solution2(): Int {
    val newLIst = mutableListOf<Int>()
    for (i in indices) {
        if (i + 2 < size)
            newLIst.add(subList(i, i + 3).sum())
    }
    return newLIst.solution1()
}

fun main() {
    println(
        """
        Day 1-1
            test1 = ${Day01().readInput("input-test.txt").solution1()} (expected: 7)
            ex1   = ${Day01().readInput("input.txt").solution1()}
            
        Day 1-2
            test2 = ${Day01().readInput("input-test.txt").solution2()} (expected: 5)
            ex1   = ${Day01().readInput("input.txt").solution2()}
    """.trimIndent()
    )
}
