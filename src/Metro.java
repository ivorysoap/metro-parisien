import net.datastructures.Graph;
import net.datastructures.SinglyLinkedList;

public class Metro{

    static SinglyLinkedList<Connection>[] adjacencyList;
    static Station[] stations;

    public Metro(int numberOfStations){

        //Initialize the array representing the set of stations.  This serves as a mapping between station numbers and station names
        stations = new Station[numberOfStations];

        //Initialize an array of SinglyLinedLists and fill it with empty SinglyLinkedLists.  This constitutes the adjacency list.
        adjacencyList = new SinglyLinkedList[numberOfStations];
        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new SinglyLinkedList<Connection>();
    }


    public void addStation(int index, Station station) { stations[index] = station; }

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







    /**
     * Lists all the stations connected to the same line as the parameter station, in order.
     * @param a   the station whose line will be listed
     */
    public static void listLine(int a){

        //TODO fix everything commented out here
        /*

            if(adjacencyList[a].size() == 1){  //if station a has only one connection (is an extremity station)

                stations[a].setExplored(true);

                if(!stations[adjacencyList[a].first().station2].getExplored() && adjacencyList[a].first().traversalTime != -1){

                }
                else if(!stations[adjacencyList[a].first().getNext().station2].getExplored() && adjacencyList[a].first().traversalTime != -1)

            }

            */

    }


    /**
     * Finds the quickest path between a and b using Dijkstra's Algorithm
     * @param a, b  two stations between which the shortest path will be found
     */
    public static void quickestPath(int a, int b){}

    /**
     * Finds the quickest path between a and b using Dijkstra's Algorithm, considering that one line
     * is closed for maintenance.  c is an extremity station of the closed line.
     * @param a, b  two stations between which the shortest path will be found
     * @param c     the extremity station of the closed line (this parameter is used to identify the closed line)
     */
    public static void quickestPath(int a, int b, int c){}



}
