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

    public static void inOrderTraversal(node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void printLevelOrder(node root) {
        if (root == null)
            return;
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelNodes = q.size();
            while (levelNodes > 0) {
                node cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
                levelNodes--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        node root = built(s);
        printLevelOrder(root);
        sc.close();
    }
}