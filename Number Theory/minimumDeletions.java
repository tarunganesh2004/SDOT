// Minimum no.of deletions to make array divisible

import java.util.Arrays;
import java.util.Scanner;

class minimumDeletions {
    public static int minOperations(int[] nums, int[] numsDivide) {
        final int gcd = getGCD(numsDivide);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0) {
                return i;
            }

        }
        return -1;
    }

    private static int getGCD(int[] nums) {
        int g = nums[0];
        for (final int num : nums) {
            g = gcd(g, num);
        }
        return g;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] numsDivide = new int[m];
        for (int i = 0; i < m; i++) {
            numsDivide[i] = sc.nextInt();
        }
        System.out.println(minOperations(nums, numsDivide));
    }
}