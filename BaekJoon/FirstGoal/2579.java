import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] score;
    static int[] dp1;
    static int[] dp2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        score = new int[n + 1];
        for (int i = 1; i <= n; i++)
            score[i] = sc.nextInt();

        dp1 = new int[n + 1];
        dp2 = new int[n + 1];
        Arrays.fill(dp2, -1);

        // dp[n] -> n번째 계단을 마지막으로 밟을 때 합 최대

        dp1[1] = score[1];
        if (n >= 2) {
            dp1[2] = score[1] + score[2];
        }

        dp2[0] = 0;
        dp2[1] = score[1];
        if (n >= 2) {
            dp2[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp1[n]);
        System.out.println(find(n));

    }

    private static int find(int n) {
        if (dp2[n] == -1) {
            dp2[n] = Math.max(find(n - 2), find(n - 3) + score[n - 1]) + score[n];
        }

        return dp2[n];
    }
}