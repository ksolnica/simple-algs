package com.ks.sort

fun swap(arr: IntArray, i: Int, j: Int) {
    val v = arr[i]
    arr[i] = arr[j]
    arr[j] = v
}