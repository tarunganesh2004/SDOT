import java.util.*;

public class evaluatePrefix {
    public static int evaluateprefix(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = s.split("\\s+");
        Collections.reverse(Arrays.asList(tokens));
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val1 - val2);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(evaluateprefix(s));
        sc.close();
    }
}