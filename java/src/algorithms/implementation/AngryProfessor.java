package algorithms.implementation;

import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int earlyStd = 0;

            for (int i = 0; i < N; i++) {
                if (sc.nextInt() <= 0)
                    earlyStd++;
            }

            System.out.println(earlyStd >= K ? "NO" : "YES");
        }
        
        sc.close();
    }
}
