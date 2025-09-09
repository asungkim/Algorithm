package DP;

import java.util.Scanner;

public class BOJ_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2] + 2;
            for (int j = i - 2; j >= 4; j -= 2) {
                dp[i] += (dp[i - j]) * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
