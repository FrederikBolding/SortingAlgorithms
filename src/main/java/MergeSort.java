import java.util.ArrayList;
import java.util.List;

public class MergeSort extends BaseAlgorithm {

    public MergeSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        MergeSortArrayRecursive(A);
        return A;
    }

    public static List<Integer> MergeSortListRecursive(List<Integer> A) {

        if (A.size() <= 1) {
            return A;
        }

        List<Integer> left = new ArrayList<>();
        for (int i = 0; i < A.size() / 2; i++) {
            left.add(A.get(i));
        }
        List<Integer> right = new ArrayList<>();
        for (int i = (A.size() / 2); i < A.size(); i++) {
            right.add(A.get(i));
        }

        left = MergeSortListRecursive(left);
        right = MergeSortListRecursive(right);

        return MergeLists(left, right);
    }


    public static List<Integer> MergeLists(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();

        while (A.size() > 0 && B.size() > 0) {

            if (A.get(0) <= B.get(0)) {
                C.add(A.get(0));
                A.remove(0);
            } else {
                C.add(B.get(0));
                B.remove(0);
            }
        }

        C.addAll(A);
        C.addAll(B);

        return C;
    }

    public static void MergeSortArrayRecursive(int[] A) {
        Visualize(A);
        MergeSortArrayRecursive(A, 0, A.length - 1);
        Visualize(A);
    }

    public static void MergeSortArrayRecursive(int[] A, int p, int r) {
        if (p < r) {
            Visualize(A);
            int q = (p + r) / 2;
            MergeSortArrayRecursive(A, p, q);
            Visualize(A);
            MergeSortArrayRecursive(A, q + 1, r);
            MergeArray(A, p, q, r);
            Visualize(A);
        }
    }

    public static void MergeArray(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                A[p] = L[i];
                i++;
            } else {
                A[p] = R[j];
                j++;
            }
            p++;
        }
        while (j < n2) {
            A[p] = R[j];
            p++;
            j++;
        }
        while (i < n1) {
            A[p] = L[i];
            p++;
            i++;
        }


    }


}
