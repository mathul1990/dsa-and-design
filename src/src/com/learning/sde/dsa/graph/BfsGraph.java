package com.learning.sde.dsa.graph;

import java.util.*;

public class BfsGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static List<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int u, int V) {
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V+1];
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Get vertices:");
        int v = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<=v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 4, 5);

        System.out.println("Adjacency list: " + adj);

        System.out.println("Bfs: " + bfs(adj, 1, 5));
    }
}
