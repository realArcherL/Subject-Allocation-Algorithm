
public class Vertex {
    private final int id;
    private final  String name;
    private boolean visited;

    Vertex(int id, String name){
        this.id = id;
        this.name = name;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    public boolean isVisited(){
        return visited;
    }
    public void setVisited(boolean visited){
        this.visited=visited;
    }

    @Override
    public String toString(){
        return  this.name;
        // return this.name+"("+this.id+")";
    }
}
