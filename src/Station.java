

public class Station{

    private int number;

    private String name;

    private boolean explored, disabled;

    //Empty Constructor
    public Station(){
        this.number = -1;
        this.name=null;
        this.explored=false;
    }

    public Station(int number, String name){
        this.number = number;
        this.name = name;
        this.explored = false;
    }

    //End of Constructors///

    //Getters
    public int getNumber(){

        return number;

    }

    public String getName(){

        return name;
    }



    public boolean getExplored() {
        return explored;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public void setNumber(int number){
        this.number = number;
    }

    @Override
    public String toString(){ return number + " " + name; }





}//End of class
