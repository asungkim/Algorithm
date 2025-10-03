package DFS;

import java.util.*;

public class BOJ_2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        List<Integer> an = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int count = dfs(new Point(i, j));
                    an.add(count);
                }
            }
        }

        Collections.sort(an);

        System.out.println(an.size());
        for (int c : an) {
            System.out.println(c);
        }
    }

    static int dfs(Point p) {
        visited[p.x][p.y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    cnt += dfs(new Point(nx, ny));
                }
            }
        }

        return cnt;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
