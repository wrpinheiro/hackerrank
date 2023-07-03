import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcs = sc.nextInt();
        
        for (int i = 0; i < tcs; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            
            StringBuilder sb = new StringBuilder();

            for (int seriesTerm = 0; seriesTerm < n; seriesTerm++) {
                int accum = a;
                for (int term = 0; term <= seriesTerm; term++) {
                    accum += (int)Math.pow(2, term) * b;
                }
                sb.append(accum).append(' ');
            }
            System.out.println(sb.toString().trim());
        }
        
        sc.close();
    }
}