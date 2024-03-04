import java.util.Stack;
import java.util.Scanner;
class queueUsingTwoStacks {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    // Main Logic
    static void enqueue(int n) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());

        }
        stack1.push(n);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    static void dequeue(int n) {
        for (int i = 0; i < n; i++) {
            stack1.pop();
        }
    }

    static void display() {
        System.out.print("Queue elements are: ");
        System.out.println();
        // print elements in stack1(Queue)
        for (int i = stack1.size() - 1; i >= 0; i--) {
            System.out.print(stack1.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            enqueue(element);
        }
        int elementsToDequeue = sc.nextInt();
        dequeue(elementsToDequeue);
        display();
        sc.close();
    }
}