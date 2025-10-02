package DFS;

import java.util.*;

public class BOJ_11724 {

    static boolean[] visited;
    static int[][] map;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        N = n;
        int m = sc.nextInt();
        visited = new boolean[n + 1];

        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            map[u][v] = map[v][u] = 1;
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    static void dfs(int idx) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (map[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}
