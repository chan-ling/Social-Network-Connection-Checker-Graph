import java.util.*;

public class SocialNetworkConnection {

    public static boolean isConnected(Map<Integer, List<Integer>> graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) {
                return true; // Connection found
            }
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return false; // No connection found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample social network (adjacency list representation)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(2));


        System.out.println("Enter the ID of the first person:");
        int person1 = scanner.nextInt();

        System.out.println("Enter the ID of the second person:");
        int person2 = scanner.nextInt();

        if (isConnected(graph, person1, person2)) {
            System.out.println("The two people are connected.");
        } else {
            System.out.println("The two people are not connected.");
        }

        scanner.close();
    }
}