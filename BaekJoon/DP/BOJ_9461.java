package DP;

import java.util.Scanner;

public class BOJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 1 1 2 2 3 4 5
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;

        for (int i = 7; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
