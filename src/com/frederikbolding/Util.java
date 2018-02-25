package com.frederikbolding;

public class Util {
    public static void Swap(int[] A, int indexA, int indexB) {
        int temp = A[indexA];
        A[indexA] = A[indexB];
        A[indexB] = temp;
    }
}
