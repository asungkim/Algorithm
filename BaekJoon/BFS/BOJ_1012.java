package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            map = new int[m][n];
            visited = new boolean[m][n];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            int cnt = 0;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        bfs(new Point(a, b));
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= m - 1 && ny <= n - 1) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
