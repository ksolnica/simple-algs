package com.ks.search

fun binarySearch(arr: IntArray, target: Int): Int {
    return if (arr.isEmpty()) -1
    else binarySearch(arr, 0, arr.size, target)
}

private fun binarySearch(arr: IntArray, start: Int, end: Int, target: Int): Int {
    if (end - start == 0) return -1
    val m = start + (end - start) / 2
    return when {
        target < arr[m] -> binarySearch(arr, start, m, target)
        target > arr[m] -> binarySearch(arr, m + 1, end, target)
        else -> m
    }
}