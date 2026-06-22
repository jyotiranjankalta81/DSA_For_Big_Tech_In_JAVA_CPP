package Stack;
import java.util.*;
public class StackConcept {

    public static void main (String[] args){
        // Java's legacy Stack class is synchronized (slow) — use ArrayDeque instead
        Deque<Integer> stack = new ArrayDeque<>();
//        LIFO (Last In First Out)
//        push(), pop(), peek()
//        O(1)

// Push
        stack.push(1);     // equivalent to addFirst() — adds to HEAD
        stack.push(2);
        stack.push(3);

// Pop
        int top = stack.pop();  // removes and returns head — 3

// Peek
        int peek = stack.peek();  // returns head without removing — 2

// Check empty
        stack.isEmpty();

// Size
        stack.size();
        System.out.println("stack***********************************"+ stack);
    }


}


/*
// Pattern 1: Balanced Brackets
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == ']' && top != '[') return false;
            if (c == '}' && top != '{') return false;
        }
    }
    return stack.isEmpty();
}

// Pattern 2: Evaluate expression / convert infix to postfix
// (uses two stacks or one stack)
public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
        if (token.equals("+") || token.equals("-") ||
            token.equals("*") || token.equals("/")) {
            int b = stack.pop(), a = stack.pop();
            switch (token) {
                case "+": stack.push(a + b); break;
                case "-": stack.push(a - b); break;
                case "*": stack.push(a * b); break;
                case "/": stack.push(a / b); break;
            }
        } else {
            stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
}

// Pattern 3: Min stack — supporting getMin in O(1)
class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        int currMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        minStack.push(currMin);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
 */