/**
 * The class runString launches the program.
 *
 * @author Ivor Benderavage
 * @author Hussein Hegazy
 *
 * CSI2510 Devoir #4
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class runString {

    private static int numberOfStations, numberOfConnections;


    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {

        File metroFile = new File("metro.txt");
        BufferedReader metroIn = new BufferedReader(new FileReader(metroFile));

        try {

            String line;
            String s;
            //Get the number of stations and connections from line 0 of the file
            String[] firstLine = metroIn.readLine().split(" ");
            StringBuilder sb = new StringBuilder(firstLine[0]);
            sb.deleteCharAt(0);
            s = sb.toString();


            numberOfStations = Integer.parseInt(s);  //parse first number in file to get number of stations
            numberOfConnections = Integer.parseInt(firstLine[1]); //parse second number in file to get number of stations

            //Declare graph
            Metro metro = new Metro(numberOfStations);

            //Now, parse the entire file.  Parsing for stations when flag=='F' and parsing for connections when flag=='T'.
            char flag = 'F';
            while ((line = metroIn.readLine()) != null) {
                //Set flag to 'T' once the BufferedReader hits the line containing only the character '$'.
                //This signals the end of the section specifying the stations and the beginning of the section specifying the connections.
                if (line.charAt(0) == '$') {
                    flag = 'T';
                } else {

                    int i = 0; //index

                    if (flag == 'F') {
                        //Evaluating a STATION (flag=='F')
                        String[] lineComponents = line.split(" ", 2);
                        int stationNumber = Integer.parseInt(lineComponents[0]);
                        metro.addStation(stationNumber, new Station(stationNumber, lineComponents[1])); //add the current station to the SinglyLinkedList of stations
                    } else if (flag == 'T') {
                        //Evaluating a CONNECTION (flag=='T')
                        String[] lineComponents = line.split(" ", 3);
                        int inputTime = Integer.parseInt(lineComponents[2]);
                        metro.addConnection(Integer.parseInt(lineComponents[0]), Integer.parseInt(lineComponents[1]), inputTime); //adding all the connections to the graph
                    }
                }
            }
            metroIn.close();

            System.out.println("");
            System.out.println("");
            System.out.println("+++++++++++++++++++");
            System.out.println("");
            System.out.println("");
            System.out.println("Visual representation of the graph (adjacency list) :");
            System.out.println("");

            for (int i = 0; i < numberOfStations; i++) {
                System.out.println("<STATION " + i + ">  ----  " + metro.adjacencyList[i]);
            }


        } catch (IOException error) {
            System.out.println("error caught");
        }


        //Parse arguments as integers, and put them in their own array.
        int[] arguments = new int[args.length];
        for (int i = 0; i < args.length; i++)
            arguments[i] = Integer.parseInt(args[i]);

        //Evaluate the (integer) arguments and call the appropriate method depending on how many were passed.
        switch (arguments.length) {

            case 0:
                System.out.println("Warning: no parameters passed!  You must pass 1, 2, or 3 parameters in order to select a function. ");
                break;
            case 1:
                System.out.println("");
                System.out.println("Here is the whole line:");
                Metro.listLine(arguments[0]); //Function I: List a station's line
                break;
            case 2:
                Metro.quickestPath(arguments[0], arguments[1]); //Function II: List the shortest distance between two stations
                break;
            case 3:
                Metro.quickestPath(arguments[0], arguments[1], arguments[2]); //Function III: List the shortest distance between two stations considering a closed line
                break;
            default:
                throw new IllegalArgumentException("You must enter 1, 2, or 3 integer parameters, separated by spaces.");

        }


    }


}
