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

    fun solution1(filename: String): Int {
        val input = Day01::class.java.getResource(filename)
            ?.readText()
            ?.lines()
            ?.filter { it.isNotEmpty() }
            ?.map { it.toInt() }
            ?: throw NullPointerException("Input file not found")

        var counter = 0
        for (i in 1 until input.size) counter += if (input[i - 1] < input[i]) 1 else 0
        return counter
    }

}

fun main() {
    println("""
        Day 1-1
            test1 = ${Day01().solution1("input1-test1.txt")} (expected: 7)
            ex1   = ${Day01().solution1("input1.txt")} (expected: 1462)
    """.trimIndent())
}
