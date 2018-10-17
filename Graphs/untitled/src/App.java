import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
public class App{
    public static void main(String[] args){
        Graph graph = new Graph(11);

        //Source
        Vertex vertex0 = new Vertex(0,"Source");

        //Subject
        Vertex subject1 = new Vertex(1,"Subject1");
        Vertex subject2 = new Vertex(2,"Subject2");
        Vertex subject3 = new Vertex(3,"Subject3");

        //Teacher
        Vertex teacher1 = new Vertex(4,"Teacher1");
        Vertex teacher2 = new Vertex(5,"Teacher2");
        Vertex teacher3 = new Vertex(6,"Teacher3");
        Vertex teacher4 = new Vertex(7,"Teacher4");
        Vertex teacher5 = new Vertex(8,"Teacher5");
        Vertex teacher6 = new Vertex(9,"Teacher6");

        //sink
        Vertex vertext = new Vertex(10,"Sink");


        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(subject1);
        vertexList.add(subject2);
        vertexList.add(subject3);
        vertexList.add(teacher1);
        vertexList.add(teacher2);
        vertexList.add(teacher3);
        vertexList.add(teacher4);
        vertexList.add(teacher5);
        vertexList.add(teacher6);
        vertexList.add(vertext);

        //source to Subject
        graph.addEdge(new Edge(vertex0,subject1,2));
        graph.addEdge(new Edge(vertex0,subject2,2));
        graph.addEdge(new Edge(vertex0,subject3,2));

        //Subject to Teacher
        graph.addEdge(new Edge(subject1,teacher1,1));
        graph.addEdge(new Edge(subject1,teacher3,1));
        graph.addEdge(new Edge(subject1,teacher5,1));
        graph.addEdge(new Edge(subject1,teacher6,1));

        graph.addEdge(new Edge(subject2,teacher1,1));
        graph.addEdge(new Edge(subject2,teacher2,1));
        graph.addEdge(new Edge(subject2,teacher3,1));
        graph.addEdge(new Edge(subject2,teacher4,1));
        graph.addEdge(new Edge(subject2,teacher6,1));

        graph.addEdge(new Edge(subject3,teacher2,1));
        graph.addEdge(new Edge(subject3,teacher4,1));
        graph.addEdge(new Edge(subject3,teacher5,1));



        // Teacher to Sink
        graph.addEdge(new Edge(teacher1,vertext,1));
        graph.addEdge(new Edge(teacher2,vertext,1));
        graph.addEdge(new Edge(teacher3,vertext,1));
        graph.addEdge(new Edge(teacher4,vertext,1));
        graph.addEdge(new Edge(teacher5,vertext,1));
        graph.addEdge(new Edge(teacher6,vertext,1));

        System.out.println(graph.getNumberofEdges()+" "+ graph.getGetNumberofVertices());
        FordFulkerson ffed = new FordFulkerson(graph, vertex0, vertext);

        ffed.runEdmundsKarp();


        System.out.println(ffed.getValueOfMaxflow());

        ffed.printMaxFlowPaths(teacher1);
        ffed.printMaxFlowPaths(teacher2);
        ffed.printMaxFlowPaths(teacher3);
        ffed.printMaxFlowPaths(teacher4);
        ffed.printMaxFlowPaths(teacher5);
        ffed.printMaxFlowPaths(teacher6);

        System.out.println("Incut ");
        for (int i=0; i < vertexList.size();i++) {
            System.out.println(vertexList.get(i));
        }
        System.out.println();

    }
}
