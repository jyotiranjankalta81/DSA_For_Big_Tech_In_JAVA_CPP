package Stack;


/*
====================================================
BALANCED BRACKETS
====================================================

Question:

Check whether brackets
are balanced.

====================================================

VALID

()

{}

[]

({[]})

====================================================

INVALID

(

([)]

((

====================================================
IDEA
====================================================

Whenever opening bracket comes

Push into Stack.

----------------------------------------------------

Opening Brackets

(
{
[

====================================================

Whenever closing bracket comes

Check top of Stack.

----------------------------------------------------

)

must match

(

----------------------------------------------------

}

must match

{

----------------------------------------------------

]

must match

[

====================================================
EXAMPLE
====================================================

String:

({[]})

====================================================

(

Push

Stack:

(

====================================================

{

Push

Stack:

( {

====================================================

[

Push

Stack:

( { [

====================================================

]

Top = [

Match

Pop

Stack:

( {

====================================================

}

Top = {

Match

Pop

Stack:

(

====================================================

)

Top = (

Match

Pop

Stack:

empty

====================================================

Stack Empty

Balanced

====================================================

ANSWER = TRUE

====================================================
INVALID EXAMPLE
====================================================

([)]

----------------------------------------------------

(

Push

----------------------------------------------------

[

Push

----------------------------------------------------

)

Top = [

Need (

Mismatch

Invalid

====================================================

ANSWER = FALSE

====================================================
INTERVIEW CHEAT CODE
====================================================

Opening Bracket

Push

------------------------------------

Closing Bracket

Match Top

Pop

------------------------------------

End

Stack Empty

=> Balanced

====================================================

TIME = O(N)

SPACE = O(N)

====================================================
*/
import java.util.*;
public class BalancedBrackets {
    // Pattern 1: Balanced Brackets
    static boolean isValid(String s) {
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


    public  static boolean balancedBrackets(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
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
    public  static  void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        boolean checkIsValid = isValid(str);
        System.out.println("Is it a valid String: "+ (checkIsValid?"Valid":"Invalid"));
    }



}
