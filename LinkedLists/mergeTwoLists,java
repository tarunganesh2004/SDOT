import java.util.Scanner;

class Main {
    static node head = null;

    static class node {
        int data;
        node next;

        node(int n) {
            data = n;
            next = null;
        }
    }

    static void insert(int n) {
        node newNode = new node(n);
        if (head == null) {
            head = newNode;
        } else {
            node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    static void display() {
        node cur = head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
      System.out.print("NULL");
    }

    static node mergeTwoSortedLists(node n1, node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.data < n2.data) {
            n1.next = mergeTwoSortedLists(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoSortedLists(n1, n2.next);
            return n2;
        }
    }

    static node mergeSort(node h) {
        if (h == null || h.next == null)
            return h;

        // Get the middle of the list
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        // Set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(h);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = mergeTwoSortedLists(left, right);
        return sortedlist;
    }

    static node getMiddle(node head) {
        if (head == null)
            return head;

        node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            insert(sc.nextInt());
        }
        
        head = mergeSort(head);
        display();
    }
}
