package com.frederikbolding;

import java.util.Arrays;

public class InsertionSort {
    public static void Main(int[] A) {
        Main.visualization.Visualize(A);
        InsertionSort(A);
        Main.visualization.Visualize(A);
        System.out.println(Arrays.toString(A));
    }

    public static void InsertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            Main.visualization.Visualize(A);
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }
}
