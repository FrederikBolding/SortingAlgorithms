package com.frederikbolding;

import java.util.Arrays;

public class Quicksort {

    public static void Main(int[] A) {
        Quicksort(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }

    private static int Partition(int[] A, int p, int r) {
        int x = A[p];
        int i = p;
        for (int j = p + 1; j < r; j++) {
            if (A[j] < x) {
                Util.Swap(A, j, i + 1);
                i++;
            }
        }
        Util.Swap(A, p, i);
        return i;
    }

    private static void Quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            Quicksort(A, p, q);
            Quicksort(A, q + 1, r);
            Main.visualization.Visualize(A);
        }
    }
}
