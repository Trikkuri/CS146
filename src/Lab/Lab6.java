package Lab;

//Explanation at the bottom

import java.util.*;

public class Lab6 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, visited, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] visited, int course) {
        if (visited[course] == 1) {
            return false;
        }
        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;
        for (int neighbor : adj.get(course)) {
            if (!dfs(adj, visited, neighbor)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of courses:");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        List<int[]> prerequisites = new ArrayList<>();
        System.out.println("Enter prerequisite pairs 'a b'. Enter 'done' when finished:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            prerequisites.add(new int[]{a, b});
        }

        int[][] prerequisitesArray = prerequisites.toArray(new int[prerequisites.size()][2]);

        Lab6 solution = new Lab6();
        boolean result = solution.canFinish(numCourses, prerequisitesArray);
        System.out.println(result);

        scanner.close();
    }
}

/*
For the input, numCourses represents the nodes in the graph.
Prerequisite pairs [a, b] indicates that to take course a, you
need to take course b first. The prerequisite pair is converted
to a 2D array. This is iterated over to fill an adj list where each
index contains a list of courses that depend on it.
I used DFS to traverse the graph, where: '0' = not visited, '1' =
currently visiting, and '2' = finished visiting.
 */