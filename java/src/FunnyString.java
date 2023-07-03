import java.util.Scanner;

public class FunnyString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        sc.nextLine();

        while (t-- > 0) {
            char[] s = sc.nextLine().toCharArray();
            int l = s.length - 1;

            boolean funny = true;

            for (int i = 1; i < s.length && funny; i++) {
                if (Math.abs(s[i] - s[i - 1]) != Math.abs(s[l - i + 1] - s[l - i]))
                    funny = false;
            }

            System.out.println(funny ? "Funny" : "Not Funny");
        }

        sc.close();
    }

}
