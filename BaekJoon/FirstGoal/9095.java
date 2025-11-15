import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            System.out.println(dp[n]);
        }

    }
}