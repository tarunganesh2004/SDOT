import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class BalancedBrakets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        List<String> results = areBracketsBalanced(strings);
        for (String result : results) {
            System.out.println(result);
        }
        scanner.close();

    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);

            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((c == '(' && top != ')') || (c == '[' && top != ']') || (c == '{' && top != '}')) {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    public static List<String> areBracketsBalanced(String[] strings) {
        List<String> results = new ArrayList<>();
        for (String s : strings) {
            results.add(isBalanced(s));
        }
        return results;
    }

}