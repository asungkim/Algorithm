package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724_BFS {

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
            if (!visited[i]){
                bfs(i);
                cnt++;
            }
        }


        System.out.println(cnt);


    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
