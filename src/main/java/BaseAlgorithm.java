import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

interface Algorithm {
    int[] Sort(int[] A);
}

public class BaseAlgorithm implements Algorithm {

    private int elements;
    private int[] A;

    public BaseAlgorithm(int elements) {
        this.elements = elements;
        A = GeneratePermutation(elements).stream().mapToInt(i -> i).toArray();
    }

    public static void Visualize(int[] A) {
        if (Main.visualization != null) {
            Main.visualization.Visualize(A);
        }
    }

    public void RunSort() {
        if (Main.visualization != null) {
            Main.visualization.SetTitle(this.getClass().getSimpleName());
        }
        System.out.println("Running " + this.getClass().getSimpleName());
        System.out.println(Arrays.toString(A));
        A = Sort(A);
        System.out.println(Arrays.toString(A));
        boolean sorted = Util.IsSorted(A);
        assert sorted;
    }

    public int[] Sort(int[] A) {
        throw new NotImplementedException();
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
