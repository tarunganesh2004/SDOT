import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stackUsingQueues {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    static void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }
    
    static void pop() {
        if (q1.isEmpty())
            return;
        q1.remove();
    }
    
    static int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    static int size() {
        return q1.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            push(element);
        }
        System.out.println("Size of stack: " + size());
        System.out.println("Top element: " + top());
        pop();
        System.out.println(size());
        sc.close();
    }
}
