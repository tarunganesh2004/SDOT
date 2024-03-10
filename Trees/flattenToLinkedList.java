// Flatten a Binary Tree to LinkedList
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

public class flattenToLinkedList {
    public static void flatten(node root) {
        if (root == null)
            return;
        node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                node rightMost = cur.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right; // Move to the next node in the linked list
        }
    }

    public static void printList(node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
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
        flatten(root);
        printList(root);
        sc.close();
    }
}