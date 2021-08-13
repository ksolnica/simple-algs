package com.ks.search

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class SortTest {
    private val algorithms = mapOf<String, (arr: IntArray, i: Int) -> Int>(
        "binary search" to { arr, i -> binarySearch(arr, i) }
    )
    private val data = mapOf(
        intArrayOf() to 1 to -1,
        intArrayOf(1) to 1 to 0,
        intArrayOf(1, 2) to 2 to 1,
        intArrayOf(1, 2, 3) to 3 to 2,
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) to 7 to 6,
        intArrayOf(1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 10) to 7 to 8,
        intArrayOf(1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10) to 3 to 2,
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) to 11 to -1,
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) to 0 to -1,
        intArrayOf(1, 3, 5, 6) to 7 to -1
    )

    @TestFactory
    fun shouldSearch() = algorithms
        .flatMap { a -> data.map { a to it } }
        .map {
            val name = it.first.key
            val search = it.first.value
            val input = it.second.key.first
            val target = it.second.key.second
            val index = it.second.value
            DynamicTest.dynamicTest("$name ${input.asList()} ? $target => $index") {
                assertEquals(index, search(input, target))
            }
        }
}