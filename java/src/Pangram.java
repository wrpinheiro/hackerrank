import java.util.Scanner;

public class Pangram {

    public static void main(String[] args) {
        int[] p = new int['z' - 'a' + 1];
        int sum = 0;
        
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
            sum += i + 1;
        }
        
        Scanner sc = new Scanner(System.in);
        
        char[] pangram = sc.nextLine().toLowerCase().toCharArray();
        
        for (char s : pangram) {
            if (s >= 'a' && s <= 'z') {
                sum -= p[s - 'a'];
                p[s - 'a'] = 0;
            }
        }
        
        System.out.println(sum == 0 ? "pangram" : "not pangram");

        sc.close();
    }

}
