import java.util.Random;

public class BogoSort extends BaseAlgorithm {

    private static Random random;

    public BogoSort(int elements) {
        super(elements);
    }

    public int[] Sort(int[] A) {
        Visualize(A);
        BogoSort(A);
        Visualize(A);
        return A;
    }

    private static void BogoSort(int[] A) {
        while (!Util.IsSorted(A)) {
            Visualize(A);
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
