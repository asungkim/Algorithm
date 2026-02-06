import java.io.IOException;
import java.util.*;

class Main {

    static int n, k;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int a = sc.nextInt();
            arr[i] = a;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                cnt += (k / arr[i]);
                k %= arr[i];
            }

            if (k == 0)
                break;
        }

        // for (int i = 0; i < n; i++) {
        // if (arr[i] == k) {
        // System.out.println(1);
        // return;
        // } else if (arr[i] < k) {
        // answer = count(i, k);
        // break;
        // }
        // }

        System.out.println(cnt);
        // System.out.println(answer);
    }

    private static int count(int idx, int total) {
        int cnt = 0;

        while (true) {
            if (total == 0)
                break;

            if (arr[idx] > total) {
                idx++;
                continue;
            }

            cnt += total / arr[idx];
            total = total % arr[idx];

            idx++;
        }

        return cnt;
    }
}