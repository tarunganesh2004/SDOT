import java.util.*;

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

class treeCreation {
    public static node built(String s[]) {
        if (s[0] == "N" || s.length == 0)
            return null;
        Queue<node> q = new LinkedList<>();
        node root = new node(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            node cur = q.poll();
            String curVal = s[i];
            if (curVal != "N") {
                cur.left = new node(Integer.parseInt(curVal));
                q.add(cur.left);
            }
            i++;
            if (i >= s.length)
                break;
            curVal = s[i];
            if (curVal != "N") {
                cur.right = new node(Integer.parseInt(curVal));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        node root = built(s);
        sc.close();
    }
}