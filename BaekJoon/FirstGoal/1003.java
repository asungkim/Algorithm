import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] dp;

    /*
     * n 0 1
     * -----
     * 0 1 0
     * 1 0 1
     * 2 1 1
     * 3 1 2
     * 4 2 3
     * 5 3 5
     * 6 5 8
     */

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
            }
        }

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}