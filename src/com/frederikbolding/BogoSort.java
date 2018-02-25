package com.frederikbolding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoSort {

    private static Random random;

    public static void Main(int[] A) {
        Main.visualization.Visualize(A);
        BogoSort(A);
        Main.visualization.Visualize(A);
        System.out.println(Arrays.toString(A));
    }

    private static boolean IsSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void BogoSort(int[] A) {
        while (!IsSorted(A)) {
            Main.visualization.Visualize(A);
            shuffle(A);
        }
    }

    private static void shuffle(int[] A) {
        if (random == null) random = new Random();
        int count = A.length;
        for (int i = count; i > 1; i--) {
            Util.Swap(A, i - 1, random.nextInt(i));
        }
    }

}
