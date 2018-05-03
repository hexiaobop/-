package calculate;

import sun.misc.Compare;

import java.util.SortedMap;

public class Sort {
    public static void main(String[] args) {
        int[] s = {3, 7, 1,0, 2, 6, 9};
        sort2(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    private static void swap(int[] var0, int var1, int var2) {
        int var3 = var0[var1];
        var0[var1] = var0[var2];
        var0[var2] = var3;
    }

    public static void quicksort(int[] var0, int var1, int var2) {
        if (var1 < var2) {
            //swap(var0, var1, (var1 + var2) / 2);
            int var5 = var1;

            for (int var4 = var1 + 1; var4 <= var2; ++var4) {
                if (var0[var4] - var0[var1] < 0) {
                    ++var5;
                    swap(var0, var5, var4);
                }
            }

            swap(var0, var1, var5);
            quicksort(var0, var1, var5 - 1);
            quicksort(var0, var5 + 1, var2);
        }
    }

    public static void quicksort(int[] var0) {
        quicksort(var0, 0, var0.length - 1);
    }


    public static void sort(int[] s) {

        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] > s[i]) {
                int temp = s[i];
                while (i > 0 && temp < s[i - 1]) {
                    swap(s, i, i - 1);
                    i--;
                }
                s[i] = temp;
            }
        }
    }

    public static void sort2(int[] s){

        for (int i = 0; i < s.length; i++) {
            int maxIndex =i;
            int temp = s[i];
            for (int j = i+1; j < s.length; j++) {
                if(s[j]>temp){
                    temp = s[j];
                    maxIndex = j;
                }
            }
            s[maxIndex] = s[i];
            s[i]=temp;
        }
    }
}
