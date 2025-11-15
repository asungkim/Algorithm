import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] dp1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp1 = new int[n + 1];
        dp1[0] = 0;
        dp1[1] = 0;

        // dp[i] -> i의 최소 연산수

        for (int i = 2; i <= n; i++) {
            dp1[i] = dp1[i - 1] + 1;
            if (i % 2 == 0) {
                dp1[i] = Math.min(dp1[i], dp1[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp1[i] = Math.min(dp1[i], dp1[i / 3] + 1);
            }
        }

        System.out.println(dp1[n]);
    }
}