import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int[] dp;
    static Integer[] dp2;
    static int[] tails;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        dp2 = new Integer[n];
        tails = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int size = 0;
        for (int x : arr) {
            int pos = lowerBound(tails, 0, size, x);
            tails[pos] = x;
            if (pos == size)
                size++;
        }

        System.out.println(size);

        // dp[i] -> i번째 까지의 최대 길이

        // for (int i = 0; i < n; i++) {
        // dp[i] = 1;
        // for (int j = 0; j < i; j++) {
        // if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
        // dp[i] = dp[j] + 1;
        // }
        // }
        // }

        // int max = -1;
        // for (int i = 0; i < n; i++) {
        // max = Math.max(max, dp2[i]);
        // }
        // System.out.println(max);
    }

    private static int lowerBound(int[] a, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] >= target) {
                r = mid;
            } else
                l = mid + 1;
        }

        return l;
    }

    private static int recur(int x) {
        if (dp2[x] == null) {
            dp2[x] = 1;

            for (int i = 0; i < x; i++) {
                if (arr[i] < arr[x]) {
                    dp2[x] = Math.max(dp2[x], recur(i) + 1);
                }
            }
        }

        return dp2[x];
    }
}