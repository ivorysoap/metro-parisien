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

        int startStation = a;//start
        int endStation = b;//end
        int[] newPosition= null;//array of results
        boolean finished=false;//boolean to check if it was finished

        int currentTime=0;

        //for loop that gois through the adjancency
        for(Connection c : adjacencyList[b]){

            //if the two station are already connect
            //either overlapping or one stop away
            //it will switch boolean to finished
            //and make sure that if it's walkable that the distance is 90
            if(c.getStation2()==b && c.getStation1()==a){
                System.out.println("connected");
                finished=true;
                currentTime=c.getTraversalTime();
                if(currentTime==-1){
                    currentTime=90;
                }
            }

        }

        //aslong as the it's not finished
        //go through the list
        //trying to form dijstra's track
        if(!finished){

            for(Connection c : adjacencyList[startStation]){

                stations[c.getStation1()].setExplored(true);
                newPosition = getShortestDistance(startStation, currentTime);//call to get shortest distance depending
                //on the traveling distance previously inputted
                currentTime = newPosition[0];//iterate time

                if(!stations[newPosition[1]].getDisabled()) {
                    endStation = newPosition[1];//go to next station
                }

                DjList[startStation].addLast(new Connection(startStation, endStation, currentTime));
                startStation = endStation;

            }
        }

            endStation=b;//once it's reached the final stop
        //you need to put final stop with final time

            if(finished){
                endStation=a;//if finished endStation
            }

            //add in the currentTime left
            for (Connection c: adjacencyList[startStation]) {
                if(c.getStation1() ==startStation && c.getStation2()==endStation){
                    currentTime+=c.getTraversalTime();
                }
            }

            DjList[endStation].addLast(new Connection(endStation,startStation,currentTime));

        System.out.print(endStation);
        //for (int i = 0; i < DjList.length; i++) {
            System.out.println("------------------------LAST DIJSKTRA----------------");
            System.out.println("<STATION " + endStation + ">  ----  " + DjList[endStation]);
        //}



    }


    /**
     * Returns the correct time it takes to go from one station to the other
     * If the distance is walkable then the time it takes is 90 seconds
     *returns the shortest distance depending on the last currentTime
     * @param index
     * @param currentTime
     *
     */

    public static int[] getShortestDistance(int index, int currentTime){

        int distance = Integer.MAX_VALUE;
        int station=0;

        for(Connection con : adjacencyList[index]){


            if(con.getTraversalTime() < distance && con.getTraversalTime() !=-1 ){

                distance = con.getTraversalTime();
                station = con.getStation2();//found shortest distance to reach the second station

            }else if(con.getTraversalTime()==-1 && distance+currentTime >=90){
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
    public static void quickestPath(int a, int b, int c){


        stations[c].setDisabled(false);
        for(Connection con: adjacencyList[c]){
            con.setDisabled(false);
        }

        quickestPath(a,b);



    }



}
