public class Connection {

    Station station1, station2;

    int traversalTime;

    boolean discovered, disabled;

    public Connection(Station station1, Station station2, int traversalTime){
        this.station1 = station1;
        this.station2 = station2;
        this.traversalTime = traversalTime;
        this.discovered = false;
        this.disabled = false;
    }

    public Station getStation1() {
        return station1;
    }

    public void setStation1(Station station1) {
        this.station1 = station1;
    }

    public Station getStation2() {
        return station2;
    }

    public void setStation2(Station station2) {
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
}
