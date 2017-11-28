
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
                    char lineFlag = 'S';
                    char currChar;
                    System.out.print("Station name: ");
                    while(currChar != ' ')
                        currChar = metroIn.read();
                }
            }
            metroIn.close();

        }catch(IOException error){
            System.out.println("error caught");
        }



    }//end of psvm
}
