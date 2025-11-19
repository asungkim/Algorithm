import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    // static int[] dp;
    static int[] list;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        list = new int[n];
        for (int x : arr) {
            int pos = binarySearch(x);
            list[pos] = x;

            if (pos == size)
                size++;
        }

        System.out.println(size);

        // dp[i] -> i-1 idx까지 봤을떄 증가수열 최대 길이
        // dp = new int[n];
        // int max = -1;
        // for (int i = 0; i < n; i++) {
        // dp[i] = 1;

        // for (int j = 0; j < i; j++) {
        // if (arr[i] > arr[j]) {
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // }
        // }
        // max = Math.max(max, dp[i]);
        // }

        // System.out.println(max);

    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) / 2;

            if (list[mid] < target) {
                left = mid + 1;
            } else
                right = mid;
        }

        return left;
    }
}