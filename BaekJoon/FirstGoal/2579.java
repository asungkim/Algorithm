import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int[] dp;
    static Integer[] dp2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n + 1];
        dp2 = new Integer[n + 1];

        dp[1] = arr[1];
        dp2[0] = 0;
        dp2[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
            dp2[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        // System.out.println(dp[n]);
        System.out.println(recur(n));
    }

    private static int recur(int n) {
        if (dp2[n] == null) {
            dp2[n] = Math.max(recur(n - 2), recur(n - 3) + arr[n - 1]) + arr[n];
        }

        return dp[n];
    }
}