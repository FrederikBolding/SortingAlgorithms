public class HeapSort extends BaseAlgorithm {

    public HeapSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        BuildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            Visualize(A);
            Util.Swap(A, 0, i);
            MaxHeapify(A, 0, i);
            Visualize(A);
        }
        return A;
    }

    private static void BuildMaxHeap(int[] A) {
        for (int i = (A.length / 2); i >= 0; i--) {
            MaxHeapify(A, i, A.length);
        }
    }

    private static void MaxHeapify(int[] A, int i, int n) {
        int l = GetLeft(i);
        int r = GetRight(i);
        int largest;
        if (l < n && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < n && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            Util.Swap(A, i, largest);
            MaxHeapify(A, largest, n);
        }
    }

    private static int GetLeft(int i) {
        return (2 * i) + 1;
    }

    private static int GetRight(int i) {
        return (2 * i) + 2;
    }

}
