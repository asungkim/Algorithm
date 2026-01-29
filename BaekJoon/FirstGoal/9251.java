import java.io.IOException;
import java.util.*;

class Main {

    static char[] c1;
    static char[] c2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        c1 = sc.next().toCharArray();
        c2 = sc.next().toCharArray();

        // ACAYKP
        // CAPCAK

        // 011111
        // 111222
        // 111233

        dp = new int[c1.length + 1][c2.length + 1];
        // dp[i][j] -> c1의 i까지, c2의 j까지 보았을때 최장 길이

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[c1.length][c2.length]);
    }

    // private static int lcs(int x, int y) {
    // if (x == -1 || y == -1) {
    // return 0;
    // }

    // if (dp[x][y] == null) {
    // dp[x][y] = 0;

    // if (c1[x] == c2[y]) {
    // dp[x][y] = lcs(x - 1, y - 1) + 1;
    // } else {
    // dp[x][y] = Math.max(lcs(x, y - 1), lcs(x - 1, y));
    // }
    // }

    // return dp[x][y];
    // }
}