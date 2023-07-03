import java.util.Scanner;

public class Array1DHard {
    public static boolean findSolution(int[] a, int current, int m) {
        if (current >= a.length) {
            return true;
        } else if (current < 0 || a[current] == 1) {
            return false;
        } else {
            a[current] = 1;
            return findSolution(a, current - 1, m)  ||
                    findSolution(a, current + 1, m ) ||
                    findSolution(a, current + m, m);
        }
    }
    
    public static void main(String[] args) {
//        int[] array = {0, 1, 0, 0, 1, 0, 1}; int m = 3;
//        int[] array = {0, 0, 0, 0, 0}; int m = 3;
//        int[] array = {0, 0, 0, 1, 1, 1}; int m = 5;
//        int[] a = {0, 0, 1, 1, 1, 0}; int m = 3;
//        int[] array = {0, 1, 0}; int m = 1;
        
        Scanner sc = new Scanner(System.in);
        int tcs = sc.nextInt();
        
        while(tcs-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a =  new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            System.out.println(findSolution(a, 0, m) ? "YES" : "NO");
        }
        
        sc.close();
    }
}
