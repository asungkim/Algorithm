import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int[] oper;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        oper = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            oper[i] = sc.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int cur) {
        if (depth == n) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        if (oper[0] > 0) {
            oper[0]--;
            dfs(depth + 1, cur + arr[depth]);
            oper[0]++;
        }
        if (oper[1] > 0) {
            oper[1]--;
            dfs(depth + 1, cur - arr[depth]);
            oper[1]++;
        }
        if (oper[2] > 0) {
            oper[2]--;
            dfs(depth + 1, cur * arr[depth]);
            oper[2]++;
        }
        if (oper[3] > 0) {
            oper[3]--;
            dfs(depth + 1, cur / arr[depth]);
            oper[3]++;
        }
    }
}