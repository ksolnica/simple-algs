package com.ks.sort

fun bubbleSort(arr: IntArray): IntArray {
    for (i in arr.lastIndex downTo 0) {
        for (j in 0 until i) {
            if (arr[j + 1] < arr[j]) {
                swap(arr, j, j + 1)
            }
        }
    }
    return arr
}
