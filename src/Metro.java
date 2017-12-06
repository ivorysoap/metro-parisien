import java.util.LinkedList;

public class Metro{

    static LinkedList<Connection>[] adjacencyList;
    static Station[] stations;

    public Metro(int numberOfStations){

        //Initialize the array representing the set of stations.  This serves as a mapping between station numbers and station names
        stations = new Station[numberOfStations];

        //Initialize an array of SinglyLinedLists and fill it with empty SinglyLinkedLists.  This constitutes the adjacency list.
        adjacencyList = new LinkedList[numberOfStations];
        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new LinkedList<Connection>();
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
    //TODO: Broken
    public boolean isConnected(int a, int b){
        return adjacencyList[a].contains(b);
    }







    /**
     * Lists all the stations connected to the same line as the parameter station, in order.
     * @param a   the station whose line will be listed
     */
    public static void listLine(int a){

        if(adjacencyList[a].size() == 1) {
            listLineRecursive(a);
        }
        else{
            Connection nextConnection = new Connection();
            while(adjacencyList[a].size() != 1){
                char flag = 'F';
                stations[a].setExplored(true);
                for(Connection c : adjacencyList[a]){
                    if(!stations[c.getStation2()].getExplored() && c.getTraversalTime() != -1) {
                        nextConnection = c;
                        flag = 'T';
                        break;
                    }
                }

                if(flag == 'F')
                    break;
                a = nextConnection.getStation2();
            }
            for(Station s : stations)
                s.setExplored(false);
            listLineRecursive(a);
        }



    }//end of listline

    public static void listLineRecursive(int a){

        stations[a].setExplored(true);

        System.out.println(stations[a].toString());

        for(Connection c : adjacencyList[a]){


            if(!stations[c.getStation2()].getExplored() && c.getTraversalTime() != -1){

                listLineRecursive(c.getStation2());


            }
        }

    }


    /**
     * Finds the quickest path between a and b using Dijkstra's Algorithm
     * @param a, b  two stations between which the shortest path will be found
     */
    public static void quickestPath(int a, int b){

        int currentTime=0;
        int cumulativeTime=0;
        int stops=0;
        int nextStation=a;

        while(nextStation != b){//While destination not reached

            for(Connection c: adjacencyList[nextStation]){

                //this needs to improve
                //At first step the currenttime is set to the max integer so that first value is smaller than it
                if(stops<=0){

                    currentTime=Integer.MAX_VALUE;

                    if(currentTime > getShortestDistance(c)) {

                        currentTime = getShortestDistance(c);
                        nextStation = c.getStation2();
                        stops++;

                    }

                }

                //after the first stop, we need to cumulate the time spent traveling
                if(cumulativeTime > getShortestDistance(c) && stops>0){

                    currentTime = getShortestDistance(c);
                    nextStation = c.getStation2();
                    stops++;

                }



            }//End of for

            cumulativeTime += currentTime;//Change the cumulated time //iterate

        }// End of While

        System.out.println("The number of Stops : "+stops);
        System.out.println("It would take this much time : " +cumulativeTime+ " to go from Station #" +a+ "to #" +b);
        System.out.println("Final Destination is the following: " +nextStation);

    }

    public static void position(int a, int currentTime, int nextStation){



    }

    /**
     * Returns the correct time it takes to go from one station to the other
     * If the distance is walkable then the time it takes is 90 seconds
     * @param con - connection to test
     */

    public static int getShortestDistance(Connection con){

        int distance = con.getTraversalTime();

        if(distance == -1 ){
            return 90; //if walkable then take s90 seconds --enoncé
        }else{
            return distance;
        }

    }

    /**
     * Finds the quickest path between a and b using Dijkstra's Algorithm, considering that one line
     * is closed for maintenance.  c is an extremity station of the closed line.
     * @param a, b  two stations between which the shortest path will be found
     * @param c     the extremity station of the closed line (this parameter is used to identify the closed line)
     */
    public static void quickestPath(int a, int b, int c){}



}
