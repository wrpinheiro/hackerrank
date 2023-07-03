import java.util.Scanner;

public class EquilibriumIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        int p = 0;
        long sum_left = 0;
        long sum_right = sum(A, p + 1, N); // O(n)

        while (sum_left != sum_right && p < N - 1) { // O(n)
            sum_left += A[p];
            sum_right -= A[p+1];
            p++;
        }

        System.out.println(sum_left == sum_right ? p : -1);

        sc.close();
    }

    private static long sum(long[] A, int i, int j) {
        long sum = 0;
        while (i < j) {
            sum += A[i++];
        }

        return sum;
    }
}
