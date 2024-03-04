import java.util.Scanner;
import java.util.Stack;

class infizToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // String s="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
        sc.close();
    }

    public static int prec(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if(c=='*'||c=='/'){
            return 2;
        } else if (c == '^') {
            return 3;
        } else {
            return -1;
        }
    }
    public static String infixToPostfix(String s) {
        String result = "";
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                result += c;

            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result = result + stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result = result + stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
