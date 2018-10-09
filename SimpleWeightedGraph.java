import java.util.LinkedList;

public class SimpleWeightedGraph{
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println( i + " --> " +
                            list.get(j).destination + " w " +  list.get(j).weight);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 10;
        test1.Graph graph = new test1.Graph(vertices);
        //source to subjects
        graph.addEdge( 0, 1, 2);
        graph.addEdge( 0, 2, 2);
        graph.addEdge( 0, 3, 2);
        //subjects to Teachers
        graph.addEdge( 1, 4, 1);
        graph.addEdge( 2, 4, 1);

        graph.addEdge( 2, 5, 1);
        graph.addEdge( 3, 5, 1);

        graph.addEdge( 1, 6, 1);
        graph.addEdge( 2, 6, 1);

        graph.addEdge( 3, 7, 1);
        graph.addEdge( 2, 7, 1);

        graph.addEdge(1, 8, 1);
        graph.addEdge(3, 8, 1);

        graph.addEdge( 2, 9, 1);
        graph.addEdge( 1, 9, 1);

        // teachers to sink
        graph.addEdge( 4, 10, 1);
        graph.addEdge( 5, 10, 1);
        graph.addEdge( 6, 10, 1);
        graph.addEdge( 7, 10, 1);
        graph.addEdge( 8, 10, 1);
        graph.addEdge( 9, 10, 1);

        graph.printGraph();
    }
}
