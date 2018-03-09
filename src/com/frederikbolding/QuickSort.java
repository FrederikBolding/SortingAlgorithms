package com.frederikbolding;

public class QuickSort extends BaseAlgorithm {

    public QuickSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        return Quicksort(A, 0, A.length - 1);
    }

    private static int Partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                Util.Swap(A, i, j);
            }
        }
        Util.Swap(A, i + 1, r);
        return i + 1;
    }

    private static int[] Quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            Quicksort(A, p, q - 1);
            Quicksort(A, q + 1, r);
            Main.visualization.Visualize(A);
        }
        return A;
    }
}
