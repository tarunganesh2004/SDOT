import java.util.Scanner;

class Main {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }
    }

    static node head;

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
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static node reverse(node first){
        node cur=first;
        node next=null;
        node prev=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        // first=prev;
        return prev;
    }

    static void reorder() {
        node fast = head;
        node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        node l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        node l1 = head;
        node res = new node(0);
        node temp = res;
        while (l1 != null || l2 != null) {
            if (l2 != null) {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
            if (l1 != null) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
        }
        head = temp.next;
    }
    
    static void reorderLL(node head) { // 1 2 3 4 5 , o/p: 1 5 2 4 
        if (head == null)
            return;
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node head2 = reverse(slow.next);
        slow.next = null;
        while (head != null && head2 != null) {
            node temp1 = head.next;
            node temp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = temp1;
            head2 = temp2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }
        // head = oddEvenList(head);
        // display(head);
        reorder();
        display();
        sc.close();
    }
}
