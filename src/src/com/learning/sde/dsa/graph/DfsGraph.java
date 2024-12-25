package com.learning.sde.dsa.graph;

import java.util.ArrayList;

public class DfsGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,  boolean visited[], ArrayList<Integer> ls) {
        visited[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                visited[it] = true;
                dfs(it, adj, visited, ls);
            }
        }
    }

    static ArrayList<Integer> dfsGraph(ArrayList<ArrayList<Integer>> adj, int V, int u) {
        boolean visited[] = new boolean[V+1];
        ArrayList<Integer> ls = new ArrayList<>(V);
        dfs(u, adj, visited, ls);
        return ls;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 4, 5);

        System.out.println("Adjacency list: " + adj);

        System.out.println("Bfs: " + dfsGraph(adj, 5, 1));

    }
}
