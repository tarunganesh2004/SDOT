import java.util.ArrayList;
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

public class validateBST {
    static ArrayList<Integer> a=new ArrayList<>();

    public static void inorder(node root) {
        if (root == null)
            return;
        inorder(root.left);
        a.add(root.data);
        inorder(root.right);
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
        String s[] = sc.nextLine().split(" ");
        node root = built(s);
        inorder(root);
        boolean res = true;
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) > a.get(i +1)) {
                res = false;
                break;
            }
        }
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
