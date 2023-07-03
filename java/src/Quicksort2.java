
public class Quicksort2 {

    public static void main(String[] args) {
        int[] a = { 5, 8, 1, 3, 7, 9, 2 };

        partitionAndSort(a, 0, a.length - 1);

        print(a, 0, a.length - 1);
    }

    private static void partitionAndSort(int[] a, int i, int j) {
        if (i < j) {
            int p = partition(a, i, j);
            
//            if (p - 1 )
            
            partitionAndSort(a, i, p - 1);
//            print(a, i, p - 1);
            partitionAndSort(a, p + 1, j);
            print(a, p + 1, j);
        }
    }

    private static int partition(int[] a, int s, int e) {
        int p = a[s];
        int i = s + 1, j = e;

        while (i <= j) {
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
        a[s] = a[j];
        a[j] = p;

        return j;
    }

    private static void print(int[] a, int i, int j) {
        if (i <= j) {
            for (int k = i; k <= j; k++) {
                System.out.printf("%d ", a[k]);
            }
            System.out.println();
        }
    }
}
