package algorithms.strings;

import java.util.Scanner;

public class TwoStrings {
    private static int ord(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String first = sc.nextLine();
            String second = sc.nextLine();

            boolean[] chars = new boolean[ord('z') + 1];

            for (char c : first.toCharArray()) {
                chars[ord(c)] = true;
            }

            char[] secondsChar = second.toCharArray();
            boolean found = false;

            for (int i = 0; i < secondsChar.length && !found; i++) {
                if (chars[ord(secondsChar[i])]) {
                    found = true;
                }
            }

            System.out.println(found ? "YES" : "NO");
        }

        sc.close();
    }
}
