import java.util.*;

class MaxFlowEdmondsKarp{

    static class Edge {
        int s, t, rev, cap, f;

        private Edge(int s, int t, int rev, int cap) {
            this.s = s;
            this.t = t;
            this.rev = rev;
            this.cap = cap;
        }
    }

    private static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        return graph;
    }

    private static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(s, t, graph[t].size(), cap));
        graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
    }

    private static int maxFlow(List<Edge>[] graph, int s, int t) {
        int flow = 0;
        int[] q = new int[graph.length];
        while (true) {
            int qt = 0;
            q[qt++] = s;
            Edge[] pred = new Edge[graph.length];
            for (int qh = 0; qh < qt && pred[t] == null; qh++) {
                int cur = q[qh];
                for (Edge e : graph[cur]) {
                    if (pred[e.t] == null && e.cap > e.f) {
                        pred[e.t] = e;
                        q[qt++] = e.t;
                    }
                }
            }
            if (pred[t] == null) {
                break;
            }
            //bfs
            int df = Integer.MAX_VALUE;
            for (int u = t; u != s; u = pred[u].s)
                df = Math.min(df, pred[u].cap - pred[u].f);
            for (int u = t; u != s; u = pred[u].s) {
                if(u!=s && u!=t)
                  System.out.println(u);
                pred[u].f += df;
                graph[pred[u].t].get(pred[u].rev).f -= df;
            }
            flow += df;
        }
        return (flow);
    }

    // lol
    public static void main(String[] args) {
        List<Edge>[] graph = createGraph(12);
        //source to subject
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 2);
        addEdge(graph, 0, 3, 2);
        //subjects to Teachers
        addEdge(graph, 1, 4, 1);
        addEdge(graph, 2, 4, 1);

        addEdge(graph, 2, 5, 1);
        addEdge(graph, 3, 5, 1);

        addEdge(graph, 1, 6, 1);
        addEdge(graph, 2, 6, 1);

        addEdge(graph, 3, 7, 1);
        addEdge(graph, 2, 7, 1);

        addEdge(graph, 1, 8, 1);
        addEdge(graph, 3, 8, 1);

        addEdge(graph, 2, 9, 1);
        addEdge(graph, 1, 9, 1);

        // teachers to sink
        addEdge(graph, 4, 10, 1);
        addEdge(graph, 5, 10, 1);
        addEdge(graph, 6, 10, 1);
        addEdge(graph, 7, 10, 1);
        addEdge(graph, 8, 10, 1);
        addEdge(graph, 9, 10, 1);

        // max flow = number of paths
        System.out.print("The max possible mathcings: "+maxFlow(graph, 0, 10)+"\n");
        maxFlow(graph, 0, 10);
        //checking if the operation performed is true or not
        System.out.print("Possible matchings left: "+maxFlow(graph, 0, 10));
    }
}

// https://www.dropbox.com/s/2mjrwg7wg23rkvv/EdmundKarpSEMI_IDEAL_CASE.mp4?dl=0      simulation of how the graphs is working

/*
Produced Output-> 7 pairs, max flow =6
4
1
6
1
5 			// extra pair that is getting printed
2			// this was one of the augmenting paths which was later discarded	
7			
2
8
3
9
2
5			//path discarded taken into account for max flow
3
The max possible mathcings: 6
Possible matchings left: 0

/*
Desired Output -> 6 pairs, max flow= 6
4
1
6
1
7
2
8
3
9
2
5						
3
The max possible mathcings: 6
Possible matchings left: 0
*/

