package com.ks.sort

fun selectionSort(arr: IntArray): IntArray {
    for (i in arr.indices) {
        for (j in i until arr.size) {
            if (arr[j] < arr[i]) {
                swap(arr, i, j)
            }
        }
    }
    return arr
}
