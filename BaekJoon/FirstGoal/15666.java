import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 비내림차순 -> 같거나 올라가거나
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        tmp = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    // 1 7 9 9
    // 1

    private static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = idx; i < n; i++) {
            int cur = arr[i];
            if (prev != cur) {
                prev = cur;
                tmp[depth] = cur;
                dfs(depth + 1, i);
            }
        }
    }
}