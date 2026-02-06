import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static int[] dp;
    static int[][] dp2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[k + 1];
        dp2 = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            // for (int j = k; j >= w; j--) {
            // dp[j] = Math.max(dp[j], dp[j - w] + v);
            // }
            for (int j = 0; j <= k; j++) {
                if (j < w) {
                    dp2[i][j] = dp2[i - 1][j];
                } else {
                    dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i - 1][j - w] + v);
                }
            }
        }

        // System.out.println(dp[k]);
        System.out.println(dp2[n][k]);

        // 물건의 합의 k이하 이면서 물건의 가치의 합이 최대가 되게
        // 0 0 0 6 8 12 13 14
        // 핵심 : 물건을 담거나 vs 안담거나 둘중에 최적으로 선택해.

    }
}