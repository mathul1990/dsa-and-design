package com.learning.sde.dsa.graph;

import java.util.ArrayList;

public class NumberOfProvinces {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,  boolean visited[]) {
        visited[node] = true;
        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, adj, visited);
            }
        }
    }

    /**
     * If a new component of a graph is found it is considered as a new province.
     * Such a disconnected new component will not be visited previously. so count of such
     * new components will be the count of provinces.
     */
    static int numberOfProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        boolean visited[] = new boolean[V+1];
        for (int i = 1; i< V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
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

        System.out.println("Provinces: " + numberOfProvinces(adj, 5));

    }
}
