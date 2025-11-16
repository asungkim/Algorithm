import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static int[][] dp;
    static int[] W, V;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        W = new int[n];
        V = new int[n];

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            W[i] = w;
            V[i] = v;
        }

        System.out.println(recur(n - 1, k));
    }

    private static int recur(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] == Integer.MIN_VALUE) {
            if (W[i] > k) {
                dp[i][k] = recur(i - 1, k);
            } else {
                dp[i][k] = Math.max(recur(i - 1, k), recur(i - 1, k - W[i]) + V[i]);
            }
        }

        return dp[i][k];
    }
}