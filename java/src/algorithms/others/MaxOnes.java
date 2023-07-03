package algorithms.others;

public class MaxOnes {

    public static void main(String[] args) {

        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) Math.round(Math.random());
        }

//         int[] arr = { 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0 };

        int ones = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) ones++;
        }

        int current, last, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            last = 0;
            for (int j = i; j < arr.length; j++) {
                current = last + (arr[j] == 0 ? 1 : -1);
                last = current;
                if (max < current)
                    max = current;
            }
        }

        System.out.println(ones + max);
    }
}
