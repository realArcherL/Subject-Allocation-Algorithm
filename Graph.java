import java.util.*;

// Code refrences StackOverflow
// @author ArcherL

//Creating the data Types of the Nodes(Establishing the nature)
class MapNode{

    private Set<MapEdge> edges;
    private String name;
    //Taking the node of type String first
    MapNode(String name){
        this.name = name;
        edges = new HashSet<>();   // storing edges in a Hashset( different from Lists)
    }
    // adding edge to the Hashset of edges
    void addEdge(MapEdge edge){
        edges.add(edge);
    }
    // get function fpr private variable name
    String getName(){
        return (this.name);
    }

    //adding the neighbour to the Hashset
    Set<MapNode> getNeighbors(){
        // setting new hashset to store neighbours
        Set<MapNode> neighbor = new HashSet<MapNode>(); // adding the same vertices as neighbours
        for(MapEdge edge : edges) {   // adding edges here.
            neighbor.add(edge.getDestination());
        }
        return neighbor; // sending the new function mapEdge lol!
    }

    Set<MapEdge> getEdges() {
        return this.edges; // returning the new edges safely.
    }
}

//Creating Edges with the nodes of the established nodes.
class MapEdge{
    int reverse,flux;
    private MapNode source, destination; // the vertices of the map, of type defined above.
    private int ncapacity;

    // A directed edge comprising of weight for the flow. #constructor 1
    protected MapEdge(MapNode source, MapNode destination, int ncapacity) {
        this.source = source;
        this.destination= destination;
        this.ncapacity= ncapacity;
    }
    // Man making classes private is shitty business lol
    //getter methods lol!
    MapNode getSource(){
        return this.source;
    }
    MapNode getDestination(){
        return this.destination;
    }
    int getCapacity(){
        return this.ncapacity;
    }
}

//  Fk
public class Graph {

    private int numVertices; // number of vertices = node source + node destination
    private Map<MapNode, HashSet<MapEdge>> vertices;// declaring up the haspMap with the number
    // of vertices by variable named vertices

    // creating graph using HashMap
    Graph(){
        numVertices = 0;
        vertices = new HashMap<MapNode, HashSet<MapEdge>>(); // instantiation of the declared Hashmap
    }
    // Edge needs to have a source and destination
    void addEdge(MapNode source, MapNode destination, int ncapacity) {


        if(vertices.containsKey(source)){
            //straight edge
            MapEdge map_edge = new MapEdge(source, destination, ncapacity);
            vertices.get(source).add(map_edge);
            source.addEdge(map_edge);

            // reversal edge for Maxflow
            MapEdge map_edge1= new MapEdge(destination,source,ncapacity);
            vertices.get(destination).add(map_edge1);
            source.addEdge(map_edge1);

        }
        // condition check the vertices existence
        else{
            System.out.println("Source vertex not found..");
        }
    }

    // add vertex here.
    void addVertex(MapNode V) {
        if(!vertices.containsKey(V)){ // vertex entry not empty check
            vertices.put(V, new HashSet<MapEdge>());
          //  System.out.println("vertex added successfully"); // confirmation of adding a vertex
            ++numVertices;
        }
        else // statement for pre-exsistence
            System.out.println("Already added");
    }

    ArrayList<MapNode> getNeighbor(MapNode vertex) {
        System.out.println("Hi");
        return new ArrayList<MapNode>(vertex.getNeighbors());
    }

    // to get distance between verices directly connected to each other
    int getCapacity(MapNode source, MapNode destination) {
        int ncapacity = 0;
        for(MapEdge edge : vertices.get(source)){

            if(edge.getDestination() == destination){
                ncapacity = edge.getCapacity();
                break;
            }
        }
        return ncapacity;
    }

    // No of vertices in graph
    int numVertices(){
        return numVertices;

    }

    /*  Method for EdmundsKarp      not yet done

    private static int maxFlow(Set<MapEdge> edges, MapNode source, MapNode Destination){
        Queue<MapNode> queue = new LinkedList<MapNode>();
        HashSet<MapNode> visited = new HashSet<MapNode>();
        ArrayList<String> path = new ArrayList<>();
        queue.add(source);
    }
    */

    void bfs(MapNode source){
        Queue<MapNode> queue = new LinkedList<MapNode>();   // queue for bfs
        HashSet<MapNode> visited = new HashSet<MapNode>();  // creating the HaspMap using instance
        ArrayList<String> path = new ArrayList();
        queue.add(source);

        while(!queue.isEmpty()){
            MapNode node = queue.poll();
            visited.add(node);
            Set<MapNode> neighbor = node.getNeighbors();
            System.out.print("Node " +node.getName()+ " ");
            for(MapNode V : neighbor){
                System.out.print(V.getName()+" \t");   // iteration variable lol
                if(!visited.contains(V)) {
                    queue.add(V);                // checking visited path
                    visited.add(V);
                    path.add(V.getName());
                }
            }
            System.out.println("");
        }
        System.out.println("BFS  "+path.toString());
    }

    // driver function adding datasets (pricking elements from mongoDb)
    public static void main(String[] args) {

        Graph graph = new Graph();

        // creating vertex

        //Source and Sink
        MapNode Source = new MapNode("Source");
        MapNode Sink = new MapNode("Sink");
        graph.addVertex(Source);
        graph.addVertex(Sink);

        //Subject vertices
        MapNode Subject1 = new MapNode("Subject1");
        MapNode Subject2 = new MapNode("Subject2");
        MapNode Subject3 = new MapNode("Subject3");

        //Teacher Vertices
        MapNode Teacher4 = new MapNode("Teacher1");
        MapNode Teacher5= new MapNode("Teacher2");
        MapNode Teacher6 = new MapNode("Teacher3");
        MapNode Teacher7 = new MapNode("Teacher4");
        MapNode Teacher8 = new MapNode("Teacher5");
        MapNode Teacher9 = new MapNode("Teacher6");

        // adding vertex to graph
        graph.addVertex(Subject1);
        graph.addVertex(Subject2);
        graph.addVertex(Subject3);
        graph.addVertex(Teacher4);
        graph.addVertex(Teacher5);
        graph.addVertex(Teacher6);
        graph.addVertex(Teacher7);
        graph.addVertex(Teacher8);
        graph.addVertex(Teacher9);

        // conneting edges
        // Source to Subjects
        graph.addEdge(Source, Subject1, 2);
        graph.addEdge(Source, Subject2, 2);
        graph.addEdge(Source,Subject3,2);

        //Subjects to teacher
        graph.addEdge(Teacher4, Subject1, 1);
        graph.addEdge(Teacher4, Subject2, 1);
        graph.addEdge(Teacher5, Subject3, 1);
        graph.addEdge(Teacher5, Subject2, 1);
        graph.addEdge(Teacher6,Subject1, 1);
        graph.addEdge(Teacher6, Subject2, 1);
        graph.addEdge(Teacher7,Subject2, 1);
        graph.addEdge(Teacher7, Subject3, 1);
        graph.addEdge(Teacher8, Subject1,1 );
        graph.addEdge(Teacher8, Subject3,1);
        graph.addEdge(Teacher9, Subject2,1);
        graph.addEdge(Teacher9, Subject1,1);

        // Teacher to Sink
        graph.addEdge(Teacher4, Sink, 1);
        graph.addEdge(Teacher5, Sink, 1);
        graph.addEdge(Teacher6, Sink, 1);
        graph.addEdge(Teacher7, Sink, 1);
        graph.addEdge(Teacher8, Sink, 1);
        graph.addEdge(Teacher9, Sink, 1);

       // graph.bfs(Teacher4);
        System.out.println("Distance between Subject2 to Teacher1 "+graph.getCapacity(Subject2, Teacher4));
    }
}
