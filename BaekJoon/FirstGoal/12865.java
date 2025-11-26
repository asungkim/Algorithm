import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static int[][] arr;
    static int[] dp1;
    static int[][] dp2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 최대 무게 k
        n = sc.nextInt();
        k = sc.nextInt();

        dp1 = new int[k + 1];
        dp2 = new int[n][k + 1];

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            arr[i][0] = w;
            arr[i][1] = v;
        }

        for (int j = 0; j <= k; j++) {
            if (j >= arr[0][0]) {
                dp2[0][j] = arr[0][1];
            }
        }

        for (int i = 1; i < n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = 0; j <= k; j++) {
                // dp2[i][j] -> 0~i-1번째까지의 물건을 볼때, 최대무게 j가 되게하는 가치 최댓값

                // 1) i번째 물건을 사용하지 않은 경우
                dp2[i][j] = dp2[i - 1][j];

                // 2) i번째 물건을 사용할 경우
                if (j >= w) {
                    dp2[i][j] = Math.max(dp2[i][j], dp2[i - 1][j - w] + v);
                }

            }
        }

        System.out.println(dp2[n - 1][k]);

        // for (int i = 0; i < n; i++) {
        // int weight = arr[i][0];
        // int value = arr[i][1];

        // for (int w = k; w >= weight; w--) {
        // dp1[w] = Math.max(dp1[w], dp1[w - weight] + value);
        // }
        // }

        // System.out.println(dp1[k]);
    }
}