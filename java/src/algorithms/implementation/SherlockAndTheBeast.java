package algorithms.implementation;

import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        // Its digits can only be 3's and/or 5's.
        // The number of 3's it contains is divisible by 5.
        // The number of 5's it contains is divisible by 3.
        // If there are more than one such number, we pick the largest one.
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();

            int fives = (N - (N % 3));
            int threes = N - fives;

            while (fives >= 0 && fives % 3 != 0 || threes % 5 != 0) {
                fives--;
                threes++;
            }

            if (fives < 0) {
                System.out.println(-1);
            } else {
                print(fives, threes);
            }
        }
                
        sc.close();
    }

    private static void print(int fives, int threes) {
        while (fives-- > 0)
            System.out.print("5");
        while (threes-- > 0)
            System.out.print("3");
        
        System.out.println();
    }

}
