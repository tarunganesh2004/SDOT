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

public class diameter {
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
            if (cur.data>Integer.parseInt(curVal)) {
                cur.left = new node(Integer.parseInt(curVal));
                q.add(cur.left);
    i++;
            }
            
            if (i >= s.length)
                break;
            curVal = s[i];
            if (cur.data<Integer.parseInt(curVal)) {
                cur.right = new node(Integer.parseInt(curVal));
                q.add(cur.right);
    i++;

            }
        }
        return root;
    }


    //BST Creation logic
    public static node buildBST(String[] s) {
    if (s[0].equals("N") || s.length == 0)
        return null;
    node root = new node(Integer.parseInt(s[0]));
    for (int i = 1; i < s.length; i++) {
        if (!s[i].equals("N")) {
            insertNode(root, Integer.parseInt(s[i]));
        }
    }
    return root;
}

public static void insertNode(node root, int value) {
    if (value < root.data) {
        if (root.left == null) {
            root.left = new node(value);
        } else {
            insertNode(root.left, value);
        }
    } else {
        if (root.right == null) {
            root.right = new node(value);
        } else {
            insertNode(root.right, value);
        }
    }
}


    public static int diameterofTree(node root) {
        if (root == null) {
            return 0;
        }
        int[] a = new int[1];
        height(root, a);
        return a[0];
    }

    public static int height(node root, int[] a) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, a);
        int rh = height(root.right, a);
        a[0] = Math.max(a[0], lh + rh + 1); // update the diameter using edges (lh + rh)
        return (1 + Math.max(lh, rh));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String[] s = sc.nextLine().split(" ");
        String s = "";
        int n = sc.nextInt();
        while (n != -1) {
            s += n+" ";
            n = sc.nextInt();
        }
        String s1[] = s.split(" ");
        node root = buildBST(s1);
        System.out.println("Diameter of the given binary tree is " + (diameterofTree(root)));
        sc.close();
    }
}
