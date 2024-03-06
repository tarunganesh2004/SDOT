import java.io.*;
import java.util.*;

public class dailyTemperatures {

    public static int[] dailytemperatures(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int k = stack.pop();
                res[k] = i - k;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        int[] result = dailytemperatures(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}