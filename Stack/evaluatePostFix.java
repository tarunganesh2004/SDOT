import java.util.Scanner;
import java.util.Stack;

public class evaluatePostFix {
    static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val2 = stack.pop(); // order of popping elements
                int val1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
                // stack.push(res);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            System.out.println(evaluatePostfix(x));
        }
        sc.close();
        
    }
}
