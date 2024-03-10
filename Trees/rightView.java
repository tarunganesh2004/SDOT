import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class rightView {

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

    public static void rightview(node root, List<Integer> l, int level) {
        if (root == null)
            return;
        if (l.size() == level) {
            l.add(root.data);
        }
        if (root.right != null) {
            rightview(root.right, l, level + 1);
        }
        if (root.left != null) {
            rightview(root.left, l, level+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        node root = built(s);
        ArrayList<Integer> l = new ArrayList<>();
        rightview(root, l, 0);
        for (int x : l) {
            System.out.print(x+" ");
        }
        sc.close();
    }
}
