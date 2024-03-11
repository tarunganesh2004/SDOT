import java.util.*;

class graph {
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void insertEdge(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    void bfs(int source) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            for (int i : adj[n]) {
                if (visited[i] != true) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
public class bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph g = new graph(v);
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            g.insertEdge(s, d);
        }
        int source = 0;
        g.bfs(source);
        sc.close();
    }
}
