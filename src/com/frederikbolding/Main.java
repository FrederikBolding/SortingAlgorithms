package com.frederikbolding;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static AlgorithmVisualization visualization;

    public static void Run(AlgorithmVisualization visualization) {
        Main.visualization = visualization;
        //InsertionSort.Main(GeneratePermutation(200).stream().mapToInt(i->i).toArray());
        //BogoSort.Main(GeneratePermutation(8).stream().mapToInt(i->i).toArray());
        //Quicksort.Main(GeneratePermutation(200).stream().mapToInt(i->i).toArray());
        //MergeSort.MergeSortArrayRecursive(GeneratePermutation(400).stream().mapToInt(i -> i).toArray());
        HeapSort.HeapSort(GeneratePermutation(400).stream().mapToInt(i -> i).toArray());
    }

    private static ArrayList<Integer> GeneratePermutation(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }
}
