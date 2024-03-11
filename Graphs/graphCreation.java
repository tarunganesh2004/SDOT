import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class graph {
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    graph(int v) {
        adj= new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    void Insertedge(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    // DFS 
    
    void dfs(int source) {
        boolean visited[] = new boolean[adj.length];
        Stack<Integer> st = new Stack<>();
        st.push(source);
        visited[source] = true;
        while (!st.isEmpty()) {
            int n = st.pop();
            System.out.print(n + " ");
            for (int i : adj[n]) {
                if (visited[i] != true) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
}
class graphCreation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        sc.nextLine();
        graph g = new graph(v);
        // System.out.println("enter the paths");
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt(); // source
            int d = sc.nextInt(); // destination
            sc.nextLine();
            g.Insertedge(s, d);
        }
        // Traversing
        // System.out.println("Enter the source:");
        // int source = sc.nextInt();
        int source = 0;
        g.dfs(source);
        sc.close();
    }
}