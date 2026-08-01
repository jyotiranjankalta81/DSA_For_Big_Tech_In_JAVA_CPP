package Stack.Problems;


import java.util.*;

public class EvaluateReversePolishNotation {

    public static int evaluatePostfix(String[] exp) {

        Stack<Integer> stack = new Stack<>();

        for (String token : exp) {

            if (!token.equals("+") &&
                    !token.equals("-") &&
                    !token.equals("*") &&
                    !token.equals("/")) {

                stack.push(Integer.parseInt(token));

            } else {

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }



    public static void main(String[] args) {

        String[] postfix = {"2","4","+","5","+"};

        System.out.println(evaluatePostfix(postfix));
    }
}