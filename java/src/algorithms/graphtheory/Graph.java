package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int[][] adjacencyMatrix;
    private int size;

    public Graph(int v) {
        this.adjacencyMatrix = new int[v + 1][v + 1];
        size = v;
    }

    public void addEdge(int v1, int v2) {
        adjacencyMatrix[v1][v2]++;
        adjacencyMatrix[v2][v1]++;
    }

    public List<Integer> adjacentEdges(int v) {
        List<Integer> edges = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            if (adjacencyMatrix[v][i] != 0)
                edges.add(i);
        }

        return edges;
    }

    public int size() {
        return size;
    }
}
