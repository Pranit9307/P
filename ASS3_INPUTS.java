import java.util.Scanner;

public class ASS3_INPUTS {
    static final int inf = 9999;

    static void FloydWarshall(int dist[][], int V) {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist, V);
    }

    
    static void printSolution(int dist[][], int V) {
        System.out.println("\nThe shortest path matrix is:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == inf) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int graph[][]  = new int[V][V];

        
        System.out.println("\nEnter the weights for the edges:(if no edge enter -1)");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    graph[i][j] = 0; 
                } else {
                    System.out.print("Enter weight from vertex " + (i + 1) + " to vertex " + (j + 1) + ": ");
                    int weight = sc.nextInt();
                    graph[i][j] = (weight == -1) ? inf : weight; 
                }
            }
        }

        FloydWarshall(graph, V);

        sc.close();
    }
}
