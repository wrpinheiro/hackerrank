import java.util.Scanner;

public class FindPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int px = sc.nextInt();
            int py = sc.nextInt();
            int qx = sc.nextInt();
            int qy = sc.nextInt();
            int sx = 2*qx - px;
            int sy = 2*qy - py;
            System.out.printf("%d %d", sx, sy);
        }
        
        sc.close();
    }

}
