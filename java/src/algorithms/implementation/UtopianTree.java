package algorithms.implementation;
import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tcs = sc.nextInt();
        
        while(tcs-- > 0) {
            int cycles = sc.nextInt();
            int height = 1;
            for (int i = 0; i < cycles; i++) {
                if (i % 2 == 0) height *= 2;
                else height++;
            }
            System.out.println(height);
        }
        
        sc.close();
    }
}