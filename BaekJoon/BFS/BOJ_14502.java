package BFS;

import java.util.*;

public class BOJ_14502 {

    static int[][] map;
    static int n, m;
    static List<Point> zeroList;
    static List<Point> virusList;
    static boolean[] visited;
    static int answer = -1;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        zeroList = new ArrayList<>();
        virusList = new ArrayList<>();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    zeroList.add(new Point(i, j));
                }
                if (map[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[zeroList.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == 3) {
            answer = Math.max(answer, bfs());
            return;
        }

        for (int i = idx; i < zeroList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[zeroList.get(i).x][zeroList.get(i).y] = 1;
                dfs(depth + 1, i + 1);
                map[zeroList.get(i).x][zeroList.get(i).y] = 0;
                visited[i] = false;
            }

        }
    }

    static int bfs() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        Queue<Point> q = new LinkedList<>();

        // 2 다 넣고 방문체크
        for (int i = 0; i < virusList.size(); i++) {
            Point xy = virusList.get(i);
            q.add(xy);
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        return countZero(copy);
    }

    static int countZero(int[][] copy) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    cnt++;
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
