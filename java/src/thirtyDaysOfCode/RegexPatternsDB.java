package thirtyDaysOfCode;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPatternsDB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        sc.nextLine();

        while (t-- > 0) {
            try {
                String pattern = sc.nextLine();
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }

        sc.close();
    }

}
