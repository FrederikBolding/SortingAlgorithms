public class Util {
    public static void Swap(int[] A, int indexA, int indexB) {
        int temp = A[indexA];
        A[indexA] = A[indexB];
        A[indexB] = temp;
    }

    public static boolean IsSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
