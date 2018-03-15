import java.util.Arrays;

public class RadixSort extends BaseAlgorithm {
    public RadixSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        Visualize(A);
        int max = Arrays.stream(A).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            A = CountingSort(A, exp);
            Visualize(A);
        }
        return A;
    }

    // Modified version of CountingSort to sort on a digit
    public int[] CountingSort(int[] A, int exp) {
        int k = Arrays.stream(A).max().getAsInt();
        int[] B = A.clone();
        int[] C = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            C[getIndex(A, j, exp)]++;
        }
        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            Visualize(B);
            B[C[getIndex(A, j, exp)] - 1] = A[j];
            C[getIndex(A, j, exp)]--;
        }
        return B;
    }

    private int getIndex(int[] A, int i, int exp) {
        return (A[i] / exp) % 10;
    }
}
