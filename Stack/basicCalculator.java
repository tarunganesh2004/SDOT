import java.util.Scanner;
import java.util.Stack;

class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = (operand * 10) + (c - '0');
            } else if (c == '+') {
                result += sign * operand;
                operand = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * operand;
                operand = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + (sign * operand);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(calculate(expression));
        scanner.close();
    }
}