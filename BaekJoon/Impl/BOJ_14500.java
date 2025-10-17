package Impl;

import java.util.Scanner;

public class BOJ_14500 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(1, map[i][j], i, j);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum, int x, int y) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny]) {

                    // 보라색 찾기 위해서 탐색 실행
                    if (depth == 2) {
                        visited[nx][ny] = true;
                        dfs(depth + 1, sum + map[nx][ny], x, y);
                        visited[nx][ny] = false;
                    }


                    visited[nx][ny] = true;
                    dfs(depth + 1, sum + map[nx][ny], nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
