package com.ks.sort

fun heapSort(arr: IntArray): IntArray {
    for (i in arr.size downTo 1) {
        while (!isMaxHeap(arr, i)) {
            for (j in 0 until i) {
                maxHeap(arr, i, j)
            }
        }
        swap(arr, 0, i - 1)
    }
    return arr
}

private fun left(i: Int) = 2 * i + 1
private fun right(i: Int) = 2 * i + 2

private fun isMaxHeap(arr: IntArray, size: Int): Boolean {
    val childBigger = { p: Int, c: Int -> c < size && arr[p] < arr[c] }
    for (i in 0 until size) {
        if (childBigger(i, left(i))) return false
        if (childBigger(i, right(i))) return false
    }
    return true
}

private fun maxHeap(arr: IntArray, size: Int, i: Int) {
    val childBigger = { p: Int, c: Int -> c < size && arr[p] < arr[c] }
    if (childBigger(i, left(i))) {
        swap(arr, left(i), i)
    }
    if (childBigger(i, right(i))) {
        swap(arr, right(i), i)
    }
}