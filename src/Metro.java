import java.util.*;

public class Metro{

    static LinkedList<Connection>[] adjacencyList;
    static LinkedList<Connection>[] DjList;
    static Station[] stations;
    static int numofStations;

    public Metro(int numberOfStations){
        numofStations=numberOfStations;
        //Initialize the array representing the set of stations.  This serves as a mapping between station numbers and station names
        stations = new Station[numberOfStations];

        //Initialize an array of SinglyLinedLists and fill it with empty SinglyLinkedLists.  This constitutes the adjacency list.
        adjacencyList = new LinkedList[numberOfStations];
        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new LinkedList<Connection>();

        DjList = new LinkedList[numberOfStations];
        for (int i = 0; i < adjacencyList.length; i++)
            DjList[i] = new LinkedList<Connection>();
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
    public static boolean isConnected(int a, int b){
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

        int startStation = a;
        int endStation = b;
        int[] newPosition= null;
        boolean finished=false;

        int currentTime=0;

        for(Connection c : adjacencyList[startStation]){

            if(c.getStation2()==b && c.getStation1()==a){
                System.out.println("connected");
                finished=true;
                currentTime=c.getTraversalTime();
                if(currentTime==-1){
                    currentTime=90;
                }
            }

        }

        if(!finished){
            for(Connection c : adjacencyList[startStation]){

                stations[c.getStation1()].setExplored(true);
                newPosition = getShortestDistance(startStation, currentTime);
                currentTime = newPosition[0];//iterate time
                endStation = newPosition[1];//go to next station
                DjList[startStation].addLast(new Connection(startStation, endStation, currentTime));
                startStation = endStation;

            }
        }



            startStation=b;

            if(finished){
                endStation=a;
            }

            for (Connection c: adjacencyList[startStation]) {
                if(c.getStation1() ==startStation && c.getStation2()==endStation){
                    currentTime+=c.getTraversalTime();
                }
            }


            DjList[startStation].addLast(new Connection(startStation,endStation,currentTime));

        System.out.print(endStation);
        for (int i = 0; i < DjList.length; i++) {
            System.out.println("<STATION " + i + ">  ----  " + DjList[i]);
        }



    }


    /**
     * Returns the correct time it takes to go from one station to the other
     * If the distance is walkable then the time it takes is 90 seconds
     * @param con - connection to test
     */

    public static int[] getShortestDistance(int index, int currentTime){

        int distance = Integer.MAX_VALUE;
        int station=0;

        for(Connection con : adjacencyList[index]){


            if(con.getTraversalTime() < distance && con.getTraversalTime() !=-1 ){

                distance = con.getTraversalTime();
                station = con.getStation2();//found shortest distance to reach the second station

            }else if(con.getTraversalTime()==-1 && distance+currentTime > 90){
                distance = 90;
            }

        }

        int[] result = {distance+currentTime,station};

        return result;

    }


    /**
     * Finds the quickest path between a and b using Dijkstra's Algorithm, considering that one line
     * is closed for maintenance.  c is an extremity station of the closed line.
     * @param a, b  two stations between which the shortest path will be found
     * @param c     the extremity station of the closed line (this parameter is used to identify the closed line)
     */
    public static void quickestPath(int a, int b, int c){}



}
