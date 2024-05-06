package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DamagedRoads {

    private int[] parent;

    public static void main(String[] args) {
        System.out.println(new DamagedRoads().solve(new int[]{1, 3}, new int[]{5, 4}));
    }

    private int solve(int[] A, int[] B) {
        initializeDSU(((A.length + 1) * (B.length + 1)) - 1);
        List<Edge> edges = generateEdges(A, B);
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        int count = 0;
        for (Edge edge : edges) {
            int sourceRoot = getRoot(edge.source);
            int destinationRoot = getRoot(edge.destination);
            if (sourceRoot != destinationRoot) {
                union(edge.source, edge.destination);
                count += edge.weight;
            }
        }
        return count;
    }

    private void initializeDSU(int n) {
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private void union(int node1, int node2) {
        node1 = getRoot(node1);
        node2 = getRoot(node2);
        parent[node1] = node2;
    }

    private int getRoot(int vertex) {
        if (vertex == parent[vertex]) {
            return vertex;
        }
        int root = getRoot(parent[vertex]);
        parent[vertex] = root;
        return root;
    }

    private List<Edge> generateEdges(int[] A, int[] B) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int source = (i * (B.length + 1)) + j;
                int destination = ((i + 1) * (B.length + 1)) + j;
                edges.add(new Edge(source, destination, A[i]));
                destination = (i * (B.length + 1)) + (j + 1);
                edges.add(new Edge(source, destination, B[j]));
            }
        }
        for (int i = 0; i < A.length; i++) {
            int source = (i * (B.length + 1)) + B.length;
            int destination = ((i + 1) * (B.length + 1)) + B.length;
            edges.add(new Edge(source, destination, A[i]));
        }
        for (int i = 0; i < B.length; i++) {
            int source = (A.length * (B.length + 1)) + i;
            int destination = (A.length * (B.length + 1)) + i + 1;
            edges.add(new Edge(source, destination, B[i]));
        }
        return edges;
    }
}