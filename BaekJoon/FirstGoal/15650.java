import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        dfs(0, 1);
    }

    private static void dfs(int depth, int tmp) {
        if (depth == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = tmp; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}