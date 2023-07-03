import java.util.Scanner;
import java.util.Stack;

public class BalancedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            Stack<Character> stack = new Stack<>();
            boolean unbalanced = false;

            int idx = 0;

            while (!unbalanced && idx < input.length()) {
                char c = input.charAt(idx++);

                if ("{[()]}".contains(c + "")) {
                    if (c == '(' || c == '[' || c == '{') {
                        stack.push(c);
                    } else {
                        if (stack.isEmpty()) {
                            unbalanced = true;
                        } else {
                            Character c1 = stack.pop();
                            if ((c == ')' && c1 != '(') || (c == ']' && c1 != '[') || (c == '}' && c1 != '{')) {
                                unbalanced = true;
                            }
                        }
                    }
                }
            }
            System.out.println(stack.isEmpty() && !unbalanced);
        }

        sc.close();
    }
}
