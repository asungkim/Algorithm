package DP;

import java.util.Scanner;

public class BOJ_2011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MOD = 1_000_000;
        String str = sc.nextLine();
        int len = str.length();

        if (str.charAt(0)=='0') {
            System.out.println(0);
            return;
        }

        // 1~26
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= len; i++) {
            int cur = str.charAt(i - 1) - '0';
            int prev = str.charAt(i - 2) - '0';
            int value = prev * 10 + cur;

            if (cur != 0) {
                dp[i] += dp[i - 1] % MOD;
            }

            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2] % MOD;
            }
        }

        System.out.println(dp[len] % MOD);


    }
}
