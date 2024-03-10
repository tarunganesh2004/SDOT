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

public class findLowestCommonAncestor {
    public static node lca(node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        // if one is in left sub tree and other is in right sub tree
        node left = lca(root.left, n1, n2);
        node right = lca(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        // other wise it is in either completely left or right sub tree
        if (left != null)
            return left;
        return right;
    }

    public static node built(String[] s) {
        if (s[0].equals("N") || s.length == 0)
            return null;
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
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        sc.close();

        node root = built(s);
        node lcaNode = lca(root, n1, n2);
        System.out.println("Lowest Common Ancestor: " + lcaNode.data);
    }
}
