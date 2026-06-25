import java.util.*;

public class ClinicGraph {

    private Map<String,
            ArrayList<String>> graph =
            new HashMap<>();

    public void addClinic(
            String clinic) {

        graph.putIfAbsent(
                clinic,
                new ArrayList<>());
    }

    public void addConnection(
            String clinic1,
            String clinic2) {

        graph.get(clinic1)
                .add(clinic2);

        graph.get(clinic2)
                .add(clinic1);
    }

    public void bfs(
            String start) {

        Queue<String> queue =
                new LinkedList<>();

        HashSet<String> visited =
                new HashSet<>();

        queue.add(start);

        visited.add(start);

        System.out.println(
                "\nBFS Traversal:");

        while(!queue.isEmpty()) {

            String current =
                    queue.poll();

            System.out.println(
                    current);

            for(String neighbor :
                    graph.get(current)) {

                if(!visited.contains(
                        neighbor)) {

                    visited.add(
                            neighbor);

                    queue.add(
                            neighbor);
                }
            }
        }
    }

    public void dfs(
            String start) {

        HashSet<String> visited =
                new HashSet<>();

        System.out.println(
                "\nDFS Traversal:");

        dfsHelper(
                start,
                visited);
    }

    private void dfsHelper(
            String clinic,
            HashSet<String> visited) {

        visited.add(clinic);

        System.out.println(
                clinic);

        for(String neighbor :
                graph.get(clinic)) {

            if(!visited.contains(
                    neighbor)) {

                dfsHelper(
                        neighbor,
                        visited);
            }
        }
    }
}