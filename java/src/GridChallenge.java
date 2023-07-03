import java.util.Scanner;

public class GridChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            char[][] g = new char[n][];
            
            for(int i = 0; i < n; i++) {
                g[i] = sc.nextLine().toCharArray();
                
                lexocographicSort(g);
            }
        }

        sc.close();
    }

    private static void lexocographicSort(char[][] g) {
        
        // TODO Auto-generated method stub
        
    }
}
