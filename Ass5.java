import java.util.Scanner;

class Ass5 {
    static int n = 8;

    static boolean isValid(int r, int c, int sol[][]) {
        return (r >= 0 && r < n && c >= 0 && c < n && sol[r][c] == -1);
    }

    static boolean solve() {
        int sol[][] = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sol[r][c] = -1;
            }
        }

        sol[0][0] = 0;
        int xM[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yM[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!solvematrix(0, 0, 1, sol, xM, yM)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    static boolean solvematrix(int r, int c, int i, int sol[][], int xM[], int yM[]) {
        if (i == n * n) {
            return true;
        }
        for (int m = 0; m < 8; m++) {
            
            int next_x = r + xM[m];
            int next_y = c + yM[m];

            if (isValid(next_x, next_y, sol)) {
                sol[next_x][next_y] = i;
                if (solvematrix(next_x, next_y, i + 1, sol, xM, yM)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    static void printSolution(int sol[][]) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(sol[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        solve();
    }
}
