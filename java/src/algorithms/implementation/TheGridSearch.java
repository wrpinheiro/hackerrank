package algorithms.implementation;
import java.util.Scanner;

public class TheGridSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            sc.nextLine();
            
            char[][] G = new char[R][];
            
            for (int i = 0; i < R; i++) {
                
                G[i] = sc.nextLine().toCharArray();
            }
            
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            sc.nextLine();
            
            char[][] P = new char[r][];
            
            for (int i = 0; i < r; i++) {
                P[i] = sc.nextLine().toCharArray();
            }
            
            int maxI = R - r;
            int maxJ = C - c;
            
            boolean found = false;
            
            print(G);
            print(P);
            
            for (int i = 0; i <= maxI && !found; i++) {
                for (int j = 0; j <= maxJ && !found; j++) {
                    if (G[i][j] == P[0][0]) {
                        found = checkPattern(G, P, i, j);
                    }
                }
            }
            if (found) {
                System.out.println("YES");    
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
    
    public static void print(char[][] m) {
        for (int i = 0; i < m.length; i++) {
//            System.out.print("==> ");
//            System.out.println(m[i]);
        }
    }

    private static boolean checkPattern(char[][] G, char[][] P, int i, int j) {
        for (int k = 0; k < P.length; k++) {
            for (int l = 0; l < P[0].length; l++) {
                if (P[k][l] != G[i+k][j+l]) 
                    return false;
            }
        }
        
        return true;
    }

}
