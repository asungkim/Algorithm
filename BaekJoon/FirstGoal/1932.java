import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static int[][] dp1;
    static int[][] dp2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        dp1 = new int[n][n];
        dp2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp2[i], -1);
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp1[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp1[i][0] = dp1[i - 1][0] + arr[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp1[i][j] = Math.max(dp1[i - 1][j - 1], dp1[i - 1][j]) + arr[i][j];
            }
        }

        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, dp1[n - 1][i]);
        }

        System.out.println(max1);
        // System.out.println(recur1(0, 0));

    }

    private static int recur1(int i, int j) {
        if (i == n - 1) {
            return arr[i][j];
        }

        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }

        int left = recur1(i + 1, j);
        int right = recur1(i + 1, j + 1);

        dp2[i][j] = Math.max(left, right) + arr[i][j];

        return dp2[i][j];
    }
}