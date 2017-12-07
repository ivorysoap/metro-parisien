import java.util.List;

public class Graph {

    private final List<Station> stations;
    private final List<Connection> connections;

    public Graph(List<Station> stations, List<Connection> connections) {
        this.stations = stations;
        this.connections = connections;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Connection> getConnections() {
        return connections;
    }



}
