import java.util.*;

public class DijkstraGraph {

    private Map<String,
            ArrayList<Edge>> graph =
            new HashMap<>();

    static class Edge {

        String destination;
        int weight;

        Edge(String destination,
             int weight) {

            this.destination =
                    destination;

            this.weight =
                    weight;
        }
    }

    public void addClinic(
            String clinic) {

        graph.putIfAbsent(
                clinic,
                new ArrayList<>());
    }

    public void addConnection(
            String source,
            String destination,
            int distance) {

        graph.get(source)
                .add(new Edge(
                        destination,
                        distance));

        graph.get(destination)
                .add(new Edge(
                        source,
                        distance));
    }

    public void shortestPath(
            String start) {

        Map<String,Integer> distance =
                new HashMap<>();

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                distance::get));

        for(String clinic :
                graph.keySet()) {

            distance.put(
                    clinic,
                    Integer.MAX_VALUE);
        }

        distance.put(
                start,
                0);

        pq.add(start);

        while(!pq.isEmpty()) {

            String current =
                    pq.poll();

            for(Edge edge :
                    graph.get(current)) {

                int newDistance =
                        distance.get(current)
                        +
                        edge.weight;

                if(newDistance
                        <
                   distance.get(
                           edge.destination)) {

                    distance.put(
                            edge.destination,
                            newDistance);

                    pq.add(
                            edge.destination);
                }
            }
        }

        System.out.println(
                "\nShortest Distances:");

        for(String clinic :
                distance.keySet()) {

            System.out.println(
                    clinic
                    + " = "
                    + distance.get(clinic));
        }
    }
}