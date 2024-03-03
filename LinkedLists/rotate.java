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
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    static void rotate(int k){
	     node cur=head;
       int c=1;
       while(c!=k){
         cur=cur.next;
         c++;
       }
       node res=cur.next;
       node result=cur.next;
       cur.next=null;
       while(res.next!=null){
         res=res.next;
       }
       res.next=head;
       head=result;
	 }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int element;
        while ((element = sc.nextInt()) != -1) {
            insert(element);
        }

        int k = sc.nextInt();

        System.out.println("List before rotation:");
        display();

        System.out.println("\nList after rotation:");
        rotate(k);
        display();
    }
}
