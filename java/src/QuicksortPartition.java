import java.util.Scanner;

public class QuicksortPartition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        partition(a);

        print(a);

        sc.close();
    }

    private static void print(int[] a) {
        for (int k = 0; k < a.length; k++) {
            System.out.printf("%d ", a[k]);
        }
    }

    private static void partition(int[] a) {
        int p = a[0];
        int i = 1, j = a.length - 1;

        while (i < j) {
            while (i <= j && a[i] <= p)
                i++;
            while (j >= i && a[j] >= p)
                j--;

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[0] = a[j];
        a[j] = p;
    }
}
