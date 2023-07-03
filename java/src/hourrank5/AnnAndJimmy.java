package hourrank5;

import java.util.Scanner;

public class AnnAndJimmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < n - 2; i ++) {
            for (int j = i; j < n - 2; j++) {
                for (int k = j; k < n - 2; k++) {
                    if (i + j + k == n) {
                        if (i * j * k > max) {
                            max = i * j * k;
                        }
                    }
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
