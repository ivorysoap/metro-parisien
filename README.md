# metro-parisien

### About

This is a Java implementation of Dijkstra's Algorithm.  It was originally written to model the Paris metro system, but you could repurpose it to do any kind of pathfinding you want.

The graph is stored in `metro.txt` in the following format:

* The first line is in the format `376 933`.  The first number tells the program how many nodes we have (e.g. stations), and the second number indicates how many edges we have (e.g. tunnels between stations).
* After the first line (but before the separator), each line indicates a node (station) in the network, and its unique number.  Format:  `0009 Assemblée Nationale`
* There is a separator line with only a `$` character to separate the previous bullet point from the next one.
* After the separator, each line indicates a tunnel between two stations (an edge) and the distance of that tunnel.  Format:  `9 78 62` (meaning that there is an edge connecting node 9 and node 78, and it has a distance of 62).



### Instructions for use

Compile and run `runString.java` and pass `1`, `2`, or `3` as a command-line argument to choose one of the three modes:

__Function 1: List all stations in a line__
To invoke this function, pass 1 argument when starting the program.

Given a station number as a parameter, P1, the program will list all other stations belonging to the same line as the given station.  The stations will be listed in order, from one extremity of the line to another.

__Function 2: Shortest path between two stations__
To invoke this function, pass 2 arguments when starting the program.

Given two station numbers as parameters, P1 and P2, the program will return the quickest path between these two stations.

__Function 3: Shortest path between two stations when one line is closed__
To invoke this function, pass 3 arguments when starting the program.

Given three station numbers as parameters, P1, P2, and P3, the program will return the quickest path between stations P1 and P2, considering the fact that P3's line is entirely closed for maintenance.
