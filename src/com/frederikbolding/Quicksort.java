package com.frederikbolding;

import javafx.util.Pair;

import java.util.Arrays;

public class Quicksort {

    public static void Quicksort(int[] A) {
        System.out.println(Arrays.toString(A));
        Quicksort(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }

    public static void Quicksort3Way(int[] A) {
        System.out.println(Arrays.toString(A));
        Quicksort3Way(A, 0, A.length - 1);
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


    private static Pair<Integer, Integer> Partition3Way(int[] A, int l, int r, int i, int j) {
        // To handle 2 elements
        if (r - l <= 1) {
            if (A[r] < A[l])
                Util.Swap(A, r, l);
            i = l;
            j = r;
            return new Pair<>(i, j);
            //return;
        }

        int mid = l;
        int pivot = A[r];
        while (mid <= r) {
            if (A[mid] < pivot)
                Util.Swap(A, l++, mid++);
            else if (A[mid] == pivot)
                mid++;
            else if (A[mid] > pivot)
                Util.Swap(A, mid, r--);
        }

        //update i and j
        i = l - 1;
        j = mid; //or high-1
        return new Pair<>(i, j);
    }


    private static void Quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            Quicksort(A, p, q);
            Quicksort(A, q + 1, r);
            Main.visualization.Visualize(A);
        }
    }

    private static void Quicksort3Way(int[] A, int l, int r) {
        if (l < r) {

            int i = 0;
            int j = 0;

            Pair<Integer, Integer> tuple = Partition3Way(A, l, r, i, j);
            i = tuple.getKey().intValue();
            j = tuple.getValue().intValue();
            Quicksort3Way(A, l, i);
            Quicksort3Way(A, j, r);
            Main.visualization.Visualize(A);
        }
    }
}
