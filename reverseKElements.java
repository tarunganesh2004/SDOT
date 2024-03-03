import java.util.Scanner;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverseKNodes(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Count the number of nodes in the current group
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        current = head;
        count = 0;
        while (count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        int k = 0;

        int data = sc.nextInt();
        while (data != -1) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }

        k = sc.nextInt();

        head = reverseKNodes(head, k);
        printList(head);

        sc.close();
    }
}