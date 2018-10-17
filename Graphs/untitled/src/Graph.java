import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int getNumberofVertices=0;
    private int numberofEdges=0;
    private List<List<Edge>> adjacenciesList;

    public Graph(int getNumberofVertices){
        this.getNumberofVertices=getNumberofVertices;
        this.numberofEdges=0;
        this.adjacenciesList = new ArrayList<>(numberofEdges);

        for (int i=0;i<getNumberofVertices;i++){
            List<Edge> edgeList = new ArrayList<>();
            adjacenciesList.add(edgeList);
        }
    }

    public int getGetNumberofVertices() {
        return getNumberofVertices;
    }

    public int getNumberofEdges() {
        return numberofEdges;
    }

    public void addEdge(Edge edge){
        Vertex v = edge.getFromVertex();
        Vertex w = edge.getTargetVertex();

        adjacenciesList.get(v.getId()).add(edge);
       // System.out.println("Edge inserted");
        adjacenciesList.get(w.getId()).add(edge);
       // System.out.println("Edge inserted");
        numberofEdges++;
    }

    public List<Edge> getAdjacenciesList(Vertex v) {
        return adjacenciesList.get(v.getId());
    }
}
