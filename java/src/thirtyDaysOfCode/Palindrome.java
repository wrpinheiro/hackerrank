package thirtyDaysOfCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    private Stack<Character> stack = new Stack<>();
    private Queue<Character> queue = new LinkedList<>();
    
    void pushCharacter(char ch) {
        stack.push(ch);
    }

    void enqueueCharacter(char ch) {
        queue.offer(ch);
    }
    
    char popCharacter() {
        return stack.pop();
    }
    char dequeueCharacter() {
        return queue.poll();
    }
}
