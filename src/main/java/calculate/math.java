package calculate;

import java.net.URISyntaxException;

public class math {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(math.class.getClass().getResource("/"));
    }

    static void xu(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int max = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    swap(a, i, j);
                }
            }
        }
        for (int q : a) {
            System.out.println(q);
        }
    }

    static void swap(int ints[], int a, int b) {
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

}
