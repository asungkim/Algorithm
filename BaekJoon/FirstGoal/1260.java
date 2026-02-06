import java.io.IOException;
import java.util.*;

class Main {

    static int n, m, v;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[start][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur + " ");

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}