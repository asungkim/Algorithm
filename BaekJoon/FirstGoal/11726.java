import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        if (n==1) {
            System.out.println
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);

    }
}