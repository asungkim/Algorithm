import java.io.IOException;
import java.util.*;

class Main {

    static int n, s;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int len = 1; len <= n; len++) {
            dfs(0, len, 0, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int len, int idx, int sum) {
        if (depth == len) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            dfs(depth + 1, len, i + 1, sum + arr[i]);
        }
    }
}