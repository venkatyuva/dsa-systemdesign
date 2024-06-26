package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EdgesInMST {

    public static void main(String[] args) {
        int[] mst = new EdgesInMST().solve(76, new int[][]{{6, 58, 601}, {42, 54, 253}, {33, 45, 146}, {14, 38, 862}, {58, 76, 152}, {12, 67, 319}, {25, 46, 964}, {9, 72, 814}, {26, 29, 908}, {26, 44, 555}, {57, 64, 477}, {45, 47, 618}, {38, 74, 212}, {3, 19, 430}, {25, 57, 265}, {21, 74, 967}, {25, 56, 532}, {1, 25, 943}, {30, 39, 699}, {20, 37, 523}, {6, 16, 156}, {22, 39, 588}, {25, 62, 258}, {12, 16, 159}, {18, 43, 465}, {7, 58, 763}, {12, 29, 511}, {31, 43, 947}, {1, 64, 66}, {25, 49, 381}, {6, 60, 166}, {48, 76, 947}, {24, 34, 541}, {62, 73, 298}, {44, 61, 43}, {38, 42, 465}, {32, 72, 195}, {49, 68, 585}, {35, 69, 271}, {57, 76, 716}, {5, 39, 201}, {3, 65, 207}, {37, 61, 107}, {57, 58, 303}, {18, 19, 697}, {1, 13, 834}, {23, 36, 612}, {71, 74, 68}, {10, 65, 416}, {20, 45, 646}, {23, 55, 176}, {21, 30, 355}, {26, 60, 449}, {27, 57, 920}, {52, 72, 80}, {11, 64, 989}, {8, 68, 322}, {17, 51, 593}, {7, 50, 598}, {10, 32, 198}, {43, 64, 510}, {2, 10, 653}, {71, 72, 72}, {67, 72, 659}, {43, 73, 123}, {44, 67, 860}, {28, 45, 998}, {18, 36, 1000}, {3, 4, 900}, {25, 63, 121}, {25, 45, 321}, {51, 62, 37}, {26, 62, 985}, {10, 63, 913}, {20, 30, 916}, {23, 45, 954}, {40, 62, 486}, {49, 67, 742}, {19, 68, 200}, {15, 23, 568}, {17, 76, 209}, {46, 55, 845}, {15, 49, 170}, {5, 69, 682}, {5, 75, 880}, {41, 68, 109}, {2, 63, 208}, {35, 64, 260}, {24, 48, 707}, {47, 76, 850}, {57, 71, 76}, {46, 50, 27}, {20, 43, 125}, {21, 62, 608}, {5, 19, 775}, {24, 35, 885}, {16, 42, 129}, {26, 57, 547}, {28, 29, 146}, {7, 14, 482}, {36, 58, 715}, {1, 66, 150}, {55, 66, 169}, {7, 70, 339}, {3, 47, 308}, {45, 57, 794}, {33, 37, 505}, {8, 34, 106}, {7, 20, 698}, {33, 40, 218}, {27, 43, 956}, {13, 43, 642}, {29, 37, 344}, {31, 47, 134}, {10, 54, 98}, {14, 41, 680}, {14, 44, 737}, {15, 71, 556}, {47, 70, 634}, {5, 31, 955}, {4, 71, 931}, {41, 61, 253}, {23, 41, 905}, {19, 63, 280}, {16, 21, 489}, {17, 53, 871}, {17, 70, 755}, {44, 65, 73}, {4, 47, 177}, {11, 33, 702}, {19, 23, 416}, {19, 71, 87}, {3, 45, 232}, {6, 38, 481}, {5, 48, 976}, {58, 69, 261}, {3, 7, 515}, {11, 34, 939}, {37, 62, 658}, {15, 36, 991}, {21, 27, 439}, {39, 43, 982}, {32, 47, 448}, {22, 43, 243}, {11, 45, 619}, {2, 43, 71}, {24, 76, 632}, {7, 13, 62}, {15, 43, 220}, {22, 32, 782}, {1, 57, 991}, {17, 69, 834}, {40, 63, 673}, {13, 57, 564}, {64, 66, 303}, {12, 44, 503}, {51, 58, 929}, {25, 76, 722}, {56, 60, 899}, {36, 76, 448}, {5, 55, 946}, {23, 24, 407}, {26, 65, 223}, {38, 51, 687}, {25, 33, 795}, {22, 60, 578}, {48, 49, 845}, {30, 66, 684}, {12, 21, 548}, {70, 75, 241}, {64, 68, 486}, {22, 53, 465}, {12, 63, 724}, {26, 51, 338}, {9, 73, 654}, {55, 70, 169}, {17, 35, 131}, {40, 56, 256}, {24, 65, 467}, {5, 67, 859}, {25, 28, 513}, {42, 44, 657}, {23, 42, 319}, {30, 41, 202}, {29, 76, 143}, {5, 52, 277}, {28, 54, 507}, {63, 68, 703}, {21, 44, 685}, {1, 4, 24}, {63, 67, 271}, {2, 7, 313}, {16, 37, 251}, {20, 25, 476}, {27, 48, 312}});
        //{{1,2,468},{2,3,335},{3,1,501},{2,4,170},{2,5,725},{2,7,479},{4,6,359},{5,6,963}}
//        int[] mst = new EdgesInMST().solve(7, new int[][]{{1, 2, 468}, {2, 3, 335}, {3, 1, 501}, {2, 4, 170}, {2, 5, 725}, {2, 7, 479}, {4, 6, 359}, {5, 6, 963}});
        for (int i = 0; i < mst.length; i++) {
            System.out.println(i + " -> " + mst[i]);
        }
    }

    private int[] parent;
    public int[] solve(int A, int[][] B) {
        List<Edge> edges = sortEdgesBasedOnWeight(B);
        initializeDSU(A);
        int[] result = new int[B.length];
        int i = 0;
        while (i < B.length) {
            int j = i;
            while (j < B.length && edges.get(i).weight == edges.get(j).weight) {
                int root1 = getRoot(edges.get(j).source);
                int root2 = getRoot(edges.get(j).destination);
                if (root1 != root2) {
                    result[edges.get(j).index] = 1;
                }
                j++;
            }
            j = i;
            while (j < B.length && edges.get(i).weight == edges.get(j).weight) {
                union(edges.get(j).source, edges.get(j).destination);
                j++;
            }
            i = j;
        }
        return result;
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

    private List<Edge> sortEdgesBasedOnWeight(int[][] B) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            edges.add(new Edge(B[i], i));
        }
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });
        return edges;
    }

    private void initializeDSU(int n) {
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
}
class Edge {
    int source;
    int destination;
    int weight;
    int index;
    public Edge(int[] edge, int index) {
        this.source = edge[0];
        this.destination = edge[1];
        this.weight = edge[2];
        this.index = index;
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{\"source\":\"" + source + "\", \"destination\": \"" + destination + "\", \"weight\": \"" + weight + "\"}";
    }
}