;import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FordFulkerson {

    private boolean[] hasPathinResidualGraph;
    private Edge[] lastEdgeOnShortesrResidualPath;
    private double valueOfMaxflow;
    private Graph graph;
    private Vertex source;
    private Vertex sink;
    private Vertex match;

    public FordFulkerson(Graph graph, Vertex source, Vertex sink){
        this.graph=graph;
        this.source=source;
        this.sink=sink;
    }

    public void runEdmundsKarp(){
        while(hasAugmentingPath()){
            double bottleneckCapacity = Double.POSITIVE_INFINITY;
            //finding the min capacity of Augmenting Paths
            for (Vertex v=sink; v!=source; v = lastEdgeOnShortesrResidualPath[v.getId()].getOtherVertex(v)) {
                bottleneckCapacity = Math.min(bottleneckCapacity, lastEdgeOnShortesrResidualPath[v.getId()].getResidualCapacity(v));
            }

            for(Vertex v=sink; v!=source; v = lastEdgeOnShortesrResidualPath[v.getId()].getOtherVertex(v)) {
                lastEdgeOnShortesrResidualPath[v.getId()].addResidualFLow(v,bottleneckCapacity);
                //if(v!=sink && v!=source) System.out.println(v);
            }
            valueOfMaxflow += bottleneckCapacity;
        }
    }

    public void printMaxFlowPaths(Vertex vertex){

        for (Edge v: graph.getAdjacenciesList(vertex)){
            if (v.getFlow()==1){
                System.out.println(v);
            }
        }
    }

    public boolean getInCut(int index){
        return hasPathinResidualGraph[index];
    }

    public double getValueOfMaxflow(){
        return valueOfMaxflow;
    }

    private boolean hasAugmentingPath(){
        lastEdgeOnShortesrResidualPath= new Edge[graph.getGetNumberofVertices()];
        hasPathinResidualGraph = new boolean[graph.getGetNumberofVertices()];

        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(source);
        hasPathinResidualGraph[source.getId()] = true;

        while (!queue.isEmpty() && !hasPathinResidualGraph[sink.getId()]){
            Vertex v = queue.remove();

            for (Edge e: graph.getAdjacenciesList(v)){
                Vertex w = e.getOtherVertex(v);

                if(e.getResidualCapacity(w) > 0){
                    if(!hasPathinResidualGraph[w.getId()]){
                        lastEdgeOnShortesrResidualPath[w.getId()]=e;
                        hasPathinResidualGraph[w.getId()] = true;
                        queue.add(w);
                    }
                }
            }
        }
        return hasPathinResidualGraph[sink.getId()];
    }
}
