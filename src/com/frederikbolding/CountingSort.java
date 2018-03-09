package com.frederikbolding;

import java.util.Arrays;

public class CountingSort extends BaseAlgorithm {

    public CountingSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        int k = Arrays.stream(A).max().getAsInt();
        int[] B = A.clone();
        Main.visualization.Visualize(B);
        int[] C = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            C[A[j]]++;
        }
        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            Main.visualization.Visualize(B);
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }
        Main.visualization.Visualize(B);
        return B;
    }

}
