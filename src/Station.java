import net.datastructures.*;

public class Station {

    private static int number;

    private static String name;

    public Station(int number, String name){
        this.number = number;
        this.name = name;
    }

    public void setNumber(int newNumber){ number = newNumber; }

    public int getNumber(){ return number; }

    public void setName(String newName){ name = newName; }

    public String getName(){ return name; }

}
