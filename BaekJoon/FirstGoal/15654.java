import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr, tmp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int num : tmp) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}