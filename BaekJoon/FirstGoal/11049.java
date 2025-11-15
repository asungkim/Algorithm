import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[i][0] = r;
            arr[i][1] = c;
        }

        // dp[i][j] -> i~j까지 연산횟수 최솟값
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(recur(0, n - 1));

    }

    private static int recur(int x, int y) {
        if (x == y)
            return 0;
        if (dp[x][y] != Integer.MAX_VALUE) {
            return dp[x][y];
        }

        for (int i = x; i < y; i++) {
            // x~i i+1~y arr[i][0]~arr[i][1]~arr[y][1]
            int tmp = recur(x, i) + recur(i + 1, y) + (arr[x][0] * arr[i][1] * arr[y][1]);

            dp[x][y] = Math.min(dp[x][y], tmp);
        }

        return dp[x][y];
    }

}
