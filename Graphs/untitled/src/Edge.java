public class Edge {
    private Vertex startVertex=null;
    private Vertex targetVertex=null;
    private double capacity=0.0;
    private double flow=0;

    public Edge(Vertex fromVertex, Vertex targetVertex, double capacity){
        this.startVertex=fromVertex;
        this.targetVertex=targetVertex;
        this.capacity=capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public Vertex getFromVertex() {
        return startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public double getFlow() {
        return flow;
    }

    public Vertex getOtherVertex(Vertex vertex){
        if (vertex.equals(startVertex))
            return targetVertex;
        else
            return startVertex;
    }

    public double getResidualCapacity(Vertex vertex){
        if (vertex.equals(startVertex))
            return flow;
        else
            return capacity-flow;
    }

    public void addResidualFLow(Vertex vertex, double deltaflow){
        if (vertex.equals(startVertex))
            flow-=deltaflow;
        else
            flow+=deltaflow;
    }

    @Override
    public String toString(){
          return  startVertex +" gets allocated to"+targetVertex;
        //return startVertex+" gets allocated to "+targetVertex+":"+flow+"/"+ capacity;
    }
}
