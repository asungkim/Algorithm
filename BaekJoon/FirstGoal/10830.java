import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static long b;
    static int[][] arr;
    static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        b = sc.nextLong();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt() % MOD;
            }
        }

        int[][] result = recur(arr, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] multiply(int[][] a1, int[][] a2) {
        int[][] an = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    an[i][j] += (a1[i][k] * a2[k][j]);
                    an[i][j] %= MOD;
                }
            }
        }

        return an;
    }

    private static int[][] recur(int[][] tmp, long exp) {
        if (exp == 1L) {
            return tmp;
        }

        int[][] half = recur(tmp, exp / 2);
        half = multiply(half, half);

        if (exp % 2 == 1L) {
            half = multiply(half, arr);
        }

        return half;
    }
}