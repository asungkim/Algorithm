import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1][2];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            // 기간-이익
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int nDay = i + arr[i][0];
            if (nDay <= n + 1) {
                dp[nDay] = Math.max(dp[nDay], dp[i] + arr[i][1]);
            }
        }

        System.out.println(Math.max(dp[n], dp[n + 1]));
    }
}