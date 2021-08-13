package com.ks.sort

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertTrue

class SortTest {
    private val algorithms = mapOf<String, (arr: IntArray) -> IntArray>(
        "selection sort" to { selectionSort(it) },
        "bubble sort" to { bubbleSort(it) },
        "insertion sort" to { insertionSort(it) },
        "heap sort" to { heapSort(it) }
    )
    private val data = mapOf(
        intArrayOf() to intArrayOf(),
        intArrayOf(1) to intArrayOf(1),
        intArrayOf(1, 1) to intArrayOf(1, 1),
        intArrayOf(1, 2) to intArrayOf(1, 2),
        intArrayOf(2, 1) to intArrayOf(1, 2),
        intArrayOf(1, 2, 3) to intArrayOf(1, 2, 3),
        intArrayOf(1, 3, 2) to intArrayOf(1, 2, 3),
        intArrayOf(1, 3, 1) to intArrayOf(1, 1, 3),
        intArrayOf(10, 5, 4, 9, 1, 3, 7, 2, 8, 6) to intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        intArrayOf(5, 10, 4, 9, 1, 3, 7, 2, 8, 6) to intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        intArrayOf(5, 10, 4, 9, 1, 3, 7, 2, 4, 8, 6) to intArrayOf(1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10)
    )

    @TestFactory
    fun shouldSort() = algorithms
        .flatMap { a -> data.map { a to it } }
        .map {
            val name = it.first.key
            val sort = it.first.value
            val input = it.second.key
            val output = it.second.value
            DynamicTest.dynamicTest("$name ${input.asList()} => ${output.asList()}") {
                assertTrue { sort(input.copyOf()) contentEquals output }
            }
        }
}