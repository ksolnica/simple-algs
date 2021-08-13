package com.ks.sort

fun insertionSort(arr: IntArray): IntArray {
    for (i in 0 until arr.lastIndex) {
        var pos = i + 1
        for (j in 0..i) {
            if (arr[j] > arr[i + 1]) {
                pos = j
                break
            }
        }
        val moved = arr[i + 1]
        for (j in i + 1 downTo pos + 1) {
            arr[j] = arr[j - 1]
        }
        arr[pos] = moved
    }
    return arr
}
