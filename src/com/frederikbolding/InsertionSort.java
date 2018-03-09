package com.frederikbolding;

public class InsertionSort extends BaseAlgorithm {

    public InsertionSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        Main.visualization.Visualize(A);
        InsertionSort(A);
        Main.visualization.Visualize(A);
        return A;
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
