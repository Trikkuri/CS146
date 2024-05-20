package HW;

//Explanation at the bottom

import java.util.*;

public class HW12 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < wells.length; i++) {
            edges.add(new int[] {0, i + 1, wells[i]});
        }
        for (int[] pipe : pipes) {
            edges.add(new int[] {pipe[0], pipe[1], pipe[2]});
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] component = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            component[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            if (edgesUsed == n) break;
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];

            if (find(component, house1) != find(component, house2)) {
                totalCost += cost;
                union(component, house1, house2);
                edgesUsed++;
            }
        }

        return totalCost;
    }

    private int find(int[] component, int house) {
        while (house != component[house]) {
            component[house] = component[component[house]];
            house = component[house];
        }
        return house;
    }

    private void union(int[] component, int house1, int house2) {
        int root1 = find(component, house1);
        int root2 = find(component, house2);
        component[root1] = root2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of houses:");
        int n = scanner.nextInt();

        int[] wells = new int[n];
        System.out.println("Enter wells:");
        for (int i = 0; i < n; i++) {
            wells[i] = scanner.nextInt();
        }

        scanner.nextLine();
        List<int[]> pipesList = new ArrayList<>();
        System.out.println("Enter pipes (enter 'done' when finished):");

        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            int[] pipe = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (pipe.length == 3) {
                pipesList.add(pipe);
            } else {
                System.out.println("Invalid pipe input, format should be: house1 house2 cost");
            }
        }

        int[][] pipes = pipesList.toArray(new int[0][]);

        System.out.println(new HW12().minCostToSupplyWater(n, wells, pipes));
        scanner.close();
    }

}

/*
With my approach to solve the problem, I treated it
as a minimum spanning tree. I used Kruskal's algorithm
which is implemented inside the minCostToSupplyWater
method. Which creates virtual node '0' edges and pipe edges
and then sorts them based on their cost. The find method identifies
what components belongs to which house (similar to findRoot) and
the union method unites the sets.
 */