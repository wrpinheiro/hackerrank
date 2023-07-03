package algorithms.graphtheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    private static class NodeInfo {
        public int vertex;
        public int distance;

        NodeInfo(int v, int distance) {
            this.vertex = v;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int vertexes = sc.nextInt();
            int edges = sc.nextInt();

            Graph g = new Graph(vertexes);

            while (edges-- > 0) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                g.addEdge(v1, v2);
            }

            int source = sc.nextInt();

            NodeInfo[] nodes = bfs(g, source);

            for (int i = 1; i <= vertexes; i++) {
                if (i == source) continue;

                NodeInfo nodeInfo = nodes[i];

                System.out.print(nodeInfo == null ? "-1" : nodeInfo.distance);
                System.out.print(" ");
            }
            
            System.out.println();
        }

        sc.close();
    }

    private static NodeInfo[] bfs(Graph g, int source) {
        NodeInfo[] visited = new NodeInfo[g.size() + 1];

        Queue<NodeInfo> q = new LinkedList<>();

        NodeInfo sourceInfo = new NodeInfo(source, 0);
        q.offer(sourceInfo);

        while (!q.isEmpty()) {
            NodeInfo v = q.poll();
            if (visited[v.vertex] == null) {
                visited[v.vertex] = v;

                g.adjacentEdges(v.vertex).stream().filter(adjVertex -> visited[adjVertex] == null).map(vertex -> new NodeInfo(vertex, v.distance
                        + 6)).forEach(q::offer);
            }
        }

        return visited;
    }
}
