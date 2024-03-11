import java.util.Arrays;

import java.util.Scanner;

class Main {

    static int primsmst(int graph[][]) {

        int v = graph.length;

        int parent[] = new int[v];

        int key[] = new int[v];

        boolean mstSet[] = new boolean[v];

        Arrays.fill(key, Integer.MAX_VALUE);

        Arrays.fill(parent, -1);

        key[0] = 0;

        parent[0] = -1;

        for (int count = 0; count < v - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int i = 0; i < v; i++) {

                if (graph[u][i] != 0 && !mstSet[i] && graph[u][i] < key[i]) {

                    parent[i] = u;

                    key[i] = graph[u][i];

                }

            }

        }

        int totalWeight = 0;

        for (int i = 1; i < v; i++)

            totalWeight += graph[i][parent[i]];

        return totalWeight;

    }

    static int minKey(int key[], boolean mstSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < key.length; v++) {

            if (mstSet[v] == false && key[v] < min) {

                min = key[v];

                min_index = v;

            }

        }

        return min_index;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();

        int e = sc.nextInt();

        int graph[][] = new int[v][v];

        for (int i = 0; i < e; i++) {

            int source = sc.nextInt();

            int destination = sc.nextInt();

            int weight = sc.nextInt();

            graph[source][destination] = weight;

            graph[destination][source] = weight;

        }

        System.out.println(primsmst(graph));

        sc.close();

    }

}