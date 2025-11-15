import java.io.IOException;
import java.util.*;

class Main {

    static int k;
    static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 비용 총합
        int t = sc.nextInt();
        for (int a = 0; a < t; a++) {
            k = sc.nextInt();
            arr = new int[k + 1];
            sum = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i - 1] + arr[i];
            }

            int[][] dp = new int[k + 1][k + 1];

            for (int len = 2; len <= k; len++) {
                for (int i = 1; i + len - 1 <= k; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int c = i; c < j; c++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][c] + dp[c + 1][j] + (sum[j] - sum[i - 1]));
                    }
                }
            }

            System.out.println(dp[1][k]);

        }
    }

    private static int recur(int x, int y) {
        if (x == y) {
            return 0;
        }

        if (dp[x][y] != Integer.MAX_VALUE) {
            return dp[x][y];
        }

        int value = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            value = Math.min(value, recur(x, i) + recur(i + 1, y) + (sum[y] - sum[x - 1]));
        }

        dp[x][y] = value;

        return value;
    }
}