package com.frederikbolding;

public class Main {

    public static AlgorithmVisualization visualization;

    public static void Run(AlgorithmVisualization visualization) {
        Main.visualization = visualization;
        RunAlgorithm(new InsertionSort(400));
        RunAlgorithm(new QuickSort(400));
        RunAlgorithm(new QuickSort3Way(400));
        RunAlgorithm(new MergeSort(400));
        RunAlgorithm(new HeapSort(400));
        RunAlgorithm(new CountingSort(400));
        RunAlgorithm(new RadixSort(400));
        RunAlgorithm(new BogoSort(8));
    }

    private static void RunAlgorithm(BaseAlgorithm algorithm) {
        long start = System.currentTimeMillis();
        algorithm.RunSort();
        System.out.println("Execution took: " + (System.currentTimeMillis() - start) + " ms.");
    }
}
