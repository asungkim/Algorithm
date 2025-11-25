import java.io.IOException;
import java.util.*;

class Main {

    static char[] arr1;
    static char[] arr2;

    static int[][] dp1;
    static int[][] dp2;

    static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        arr1 = sc.next().toCharArray();
        arr2 = sc.next().toCharArray();
        n = arr1.length;
        m = arr2.length;

        dp1 = new int[n][m];
        dp2 = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], -1);
        }

        // dp2[i][j] -> arr1 인덱스 i-1까지, arr2 인덱스 j-1까지 봤을때 최장 길이
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp2[i][j] = dp2[i - 1][j - 1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j - 1]);
                }
            }
        }

        System.out.println(dp2[n][m]);
        // System.out.println(lcs(n - 1, m - 1));
    }

    private static int lcs(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp1[x][y] == -1) {
            dp1[x][y] = 0;

            if (arr1[x] == arr2[y]) {
                dp1[x][y] = lcs(x - 1, y - 1) + 1;
            } else {
                dp1[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }

        return dp1[x][y];
    }
}