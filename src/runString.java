

import net.datastructures.*;

import javax.xml.ws.handler.soap.SOAPHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class runString {

private static int numberOfStations, numberOfConnections;


    public static void main(String[] args) throws FileNotFoundException {

        File metroFile = new File("metro.txt");
        BufferedReader metroIn = new BufferedReader(new FileReader(metroFile));

        try{

            String line;
            String s;
            //Get the number of stations and connections from line 0 of the file
            String[] firstLine = metroIn.readLine().split(" ");
            StringBuilder sb = new StringBuilder(firstLine[0]);
            sb.deleteCharAt(0);
            s = sb.toString();
            System.out.println("This map contains " + firstLine[0] + " stations connected by " + firstLine[1] + " paths.");

            numberOfStations = Integer.parseInt(s);  //parse first number in file to get number of stations
            numberOfConnections = Integer.parseInt(firstLine[1]); //parse second number in file to get number of stations

            //Declare graph
            Metro metro = new Metro(numberOfStations);

            //Now, parse the entire file.  Parsing for stations when flag=='F' and parsing for connections when flag=='T'.
            char flag = 'F';
            while((line = metroIn.readLine()) != null)
            {
                //Set flag to 'T' once the BufferedReader hits the line containing only the character '$'.
                //This signals the end of the section specifying the stations and the beginning of the section specifying the connections.
                if(line.charAt(0) == '$'){
                    flag = 'T';
                    System.out.println();
                    System.out.println("===END OF STATIONS - BEGINNING OF EDGES===");
                    System.out.println();
                }
                else{

                    int i = 0; //index

                    if(flag == 'F') {
                        //Evaluating a STATION (flag=='F')
                        String[] lineComponents = line.split(" ", 2);
                        System.out.println("Station number: " + lineComponents[0] + " / Station name: " + lineComponents[1]);
                    }
                    else if(flag == 'T'){
                        //Evaluating a CONNECTION (flag=='T')
                        String[] lineComponents = line.split(" ", 3);
                        metro.addConnection(Integer.parseInt(lineComponents[0]), Integer.parseInt(lineComponents[1]), Integer.parseInt(lineComponents[2]));  //adding all the connections to the graph
                        if(Integer.valueOf(lineComponents[2]) != -1) {
                            System.out.println("Station #" + lineComponents[0] + " is connected to station # " + lineComponents[1] + ", and it takes " + lineComponents[2] + "s to cover that distance.");

                        }
                        else {
                            System.out.println("Station #" + lineComponents[0] + " is connected to station # " + lineComponents[1] + ", and the distance is walkable.");
                        }
                    }
                }
            }
            System.out.println("EOF");
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

        }catch(IOException error){
            System.out.println("error caught");
        }





        
    }

}
