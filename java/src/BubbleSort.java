import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] a) {
        int n = a.length;

        // inv: a[i..n-1] esta ordenado não decrescente
        // inv: a[0..i-1] <= a[i]
        for (int i = n - 1; i > 0; i--) {
            // inv: array[j-1] >= array[0..j-2]
            for (int j = 1; j <= i; j++) {
                if (a[j - 1] > a[j]) {
                    int t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 23, 12, 45, 23, 11, 56, 74, 12, 34, 14 };
        new BubbleSort().sort(a);

        Arrays.stream(a).forEach(System.out::println);
    }
}

// inv: array[j-1] >= array[0..j-2]
// para j = 1 => array[0] >= array[0..-1]
// hip: para j = n - 1 => array[n - 2] >= array[0..n - 3]
//
// if (a[n - 2] > a[n - 1]) {
// troca
// }
//
// para j = n
//
// a[n - 1] >= a[0..n - 2]
//
//
// int j = 1;
// while (j <= n - 1) {
// if (array[j - 1] > array[j]) {
// troca(array, j - 1, j);
// }
// j = j + 1;
// }

//
// 23,12,45,23,11,56,74,12,34,14
// 12,23,45,23,11,56,74,12,34,14
// 12,23,45,23,11,56,74,12,34,14
// 12,23,23,45