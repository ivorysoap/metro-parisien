import net.datastructures.Graph;
import net.datastructures.SinglyLinkedList;

public class Metro{

    static SinglyLinkedList<Connection>[] adjacencyList;

    public Metro(int numberOfStations){
        //Initialize an array of SinglyLinedLists and fill it with empty SinglyLinkedLists.
        adjacencyList = new SinglyLinkedList[numberOfStations];
        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new SinglyLinkedList<Connection>();
    }

    /**
     * Adds a connection to the graph represented by the adjacency list.
     * @param a, b  stations to which the connection is attached
     * @param t     the connection's traversal time
     */
    public void addConnection(int a, int b, int t){
        adjacencyList[a].addLast(new Connection(a,b,t));
    }

    /**
     * Verifies whether or not two Stations are connected by an edge.
     * @param a, b  stations to be checked
     * @return      a boolean verifying if a and b are connected
     */
    //TODO: SinglyLinkedList's search() method has to be implented for this to work!
    public boolean isConnected(int a, int b){
        return adjacencyList[a].search(b);
    }



}
