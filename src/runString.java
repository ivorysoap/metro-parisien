
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;


public class runString {

    public static void main(String[] args) throws FileNotFoundException {

        File metroFile = new File("metro.txt");
        BufferedReader metroIn = new BufferedReader(new FileReader(metroFile));

        try{
            String line;
            //Get the number of stations and connections from line 0 of the file
            String[] firstLine = metroIn.readLine().split(" ");
            System.out.println("This map contains " + firstLine[0] + " stations connected by " + firstLine[1] + " paths.");
            //Now, parse the entire file.  Parsing for stations when flag=='F' and parsing for connections when flag=='T'.
            char flag = 'F';
            while((line = metroIn.readLine()) != null)
            {
                if(line.charAt(0) == '$'){
                    flag = 'T';
                    System.out.println();
                    System.out.println("===END OF STATIONS - BEGINNING OF EDGES===");
                    System.out.println();
                }
                else{
                    if(flag == 'F') {
                        //If treating a station, print the station's info.
                        String[] lineComponents = line.split(" ", 2);
                        System.out.println("Station number: " + lineComponents[0] + " / Station name: " + lineComponents[1]);
                    }
                    else if(flag == 'T'){
                        //If treating a connection, print the connection's info.
                        String[] lineComponents = line.split(" ", 3);
                        if(Integer.valueOf(lineComponents[2]) != -1)
                            System.out.println("Station #" + lineComponents[0] + " is connected to station # " + lineComponents[1] + ", and it takes " + lineComponents[2] + "s to cover that distance.");
                        else
                            System.out.println("Station #" + lineComponents[0] + " is connected to station # " + lineComponents[1] + ", and the distance is walkable.");
                    }

                }
            }
            System.out.println("EOF");
            metroIn.close();

        }catch(IOException error){
            System.out.println("error caught");
        }
        
    }//end of psvm

}
