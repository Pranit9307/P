import java.util.Scanner;

class Ass4 {

    public static void dijkstra(int graph[][], int src, int V) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int x = minDist(dist, sptSet, V);

            sptSet[x] = true;

            for (int y = 0; y < V; y++) {
                if (!sptSet[y] && graph[x][y] != 0 && dist[x] != Integer.MAX_VALUE && dist[x] + graph[x][y] < dist[y]) {
                    dist[y] = dist[x] + graph[x][y];
                }
            }
        }

        printSolution(dist, src, V);
    }

    
    static int minDist(int dist[], Boolean sptSet[], int V) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int y = 0; y < V; y++) {
            if (!sptSet[y] && dist[y] <= min) {
                min = dist[y];
                minIndex = y;
            }
        }
        return minIndex;
    }


    static void printSolution(int dist[], int src, int V) {
        System.out.println("\nShortest Paths from Source Vertex " + src + ":");
        System.out.println("Vertex \t\t Distance from Source");

        for (int y = 0; y < V; y++) {
            System.out.println("Vertex " + src + " -> Vertex " + y + "\t\t " + dist[y]);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter the adjacency matrix (enter 0 if there is no direct edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print("Distance between vertex " + i + " and vertex " + j + ": ");
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        int src = scanner.nextInt();

        dijkstra(graph, src, V);

        scanner.close();
    }
}
