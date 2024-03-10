import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

public class zigzagTraversal {

    public static node built(String s[]) {
        if (s[0] == "N" || s.length == 0) {
            return null;
        }
        node root = new node(Integer.parseInt(s[0]));
        Queue<node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            node cur = q.poll();
            String cur_val = s[i];
            if (!cur_val.equals("N")) {
                cur.left = new node(Integer.parseInt(cur_val));
                q.add(cur.left);
            }
            i++;
            if (i >= s.length) {
                break;
            }
            cur_val = s[i];
            if (!cur_val.equals("N")) {
                cur.right = new node(Integer.parseInt(cur_val));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void zigzag(node root) {
        if (root == null) {
            return;
        }
        Stack<node> cl = new Stack<>(); // cl - current level
        Stack<node> nl = new Stack<>(); // nl - next level
        boolean lr = true; // lr - left to right
        cl.push(root);
        while (!cl.isEmpty()) {
            node cur = cl.pop();
            System.out.print(cur.data + " ");
            if (lr) {
                if (cur.left != null) {
                    nl.push(cur.left);
                }
                if (cur.right != null) {
                    nl.push(cur.right);
                }
            } else {
                if (cur.right != null) {
                    nl.push(cur.right);
                }
                if (cur.left != null) {
                    nl.push(cur.left);
                }
            }
            if (cl.isEmpty()) {
                lr = !lr;
                Stack<node> temp = cl;
                cl = nl;
                nl = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        node root = built(s);
        zigzag(root);
        sc.close();
    }
}