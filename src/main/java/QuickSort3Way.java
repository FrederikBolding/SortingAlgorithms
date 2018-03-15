import javafx.util.Pair;

public class QuickSort3Way extends BaseAlgorithm {

    public QuickSort3Way(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        return Quicksort3Way(A, 0, A.length - 1);
    }

    private static Pair<Integer, Integer> Partition3Way(int[] A, int l, int r, int i, int j) {
        // To handle 2 elements
        if (r - l <= 1) {
            if (A[r] < A[l])
                Util.Swap(A, r, l);
            return new Pair<>(l, r);
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
        return new Pair<>(l - 1, mid);
    }

    private static int[] Quicksort3Way(int[] A, int l, int r) {
        if (l < r) {

            int i = 0;
            int j = 0;

            Pair<Integer, Integer> tuple = Partition3Way(A, l, r, i, j);
            i = tuple.getKey().intValue();
            j = tuple.getValue().intValue();
            Quicksort3Way(A, l, i);
            Quicksort3Way(A, j, r);
            Visualize(A);
        }
        return A;
    }
}
