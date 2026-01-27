import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = sc.nextInt();
            dp[i][2] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}