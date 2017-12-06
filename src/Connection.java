public class Connection {

    int station1, station2, connectionId, traversalTime;

    boolean discovered, disabled;

    //Empty constructor
    public Connection(){
        this.station1 = -1;
        this.station2 = -1;
        this.traversalTime = -1;
        this.discovered = false;
        this.disabled = false;
    }

    public Connection(int station1, int station2, int traversalTime){
        this.station1 = station1;
        this.station2 = station2;
        this.traversalTime = traversalTime;
        this.discovered = false;
        this.disabled = false;
    }

    public int getStation1() {
        return station1;
    }

    public void setStation1(int station1) {
        this.station1 = station1;
    }

    public int getStation2() {
        return station2;
    }

    public void setStation2(int station2) {
        this.station2 = station2;
    }

    public int getTraversalTime() {
        return traversalTime;
    }

    public void setTraversalTime(int traversalTime) {
        this.traversalTime = traversalTime;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString(){ return station1 + " " + station2 + " " + traversalTime; }
}
