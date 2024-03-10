import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
    int data;
    node left;
    node right;

    node(int n) {
        data = n;
        left = null;
        right = null;
    }
}

public class sumToLeafNodes{
    static int sum = 0;

    public static boolean isLeaf(node root) {
        return (root.right == null && root.left == null);
    }

    public static void leafsum(node root, int val) {
        if (root == null)
            return;
        val = val * 10 + root.data;
        if (isLeaf(root)) {
            sum += val;
            return;
        }
        leafsum(root.left, val);
        leafsum(root.right, val);

    }

    public static node built(String[] s) {
        if (s[0].equals("N") || s.length == 0) {
            return null;
        }
        Queue<node> q = new LinkedList<>();
        node root = new node(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            node cur = q.poll();
            String curVal = s[i];
            if (!curVal.equals("N")) {
                cur.left = new node(Integer.parseInt(curVal));
                q.add(cur.left);
            }
            i++;
            if (i >= s.length)
                break;
            curVal = s[i];
            if (!curVal.equals("N")) {
                cur.right = new node(Integer.parseInt(curVal));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        node root = built(s);
        leafsum(root, 0);
        System.out.println(sum);
        sc.close();

    }
}
