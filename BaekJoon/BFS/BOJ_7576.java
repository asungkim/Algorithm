package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {

    static int answer = 0;
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    static Queue<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [n][m]
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        if (q.isEmpty()) {
            System.out.println(-1);
            return;
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            answer = Math.max(answer, cur[2]);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }

        // 만약 다 퍼트렸는데도
        if (allInfect()) {
            System.out.println(answer);
        }
        else System.out.println(-1);



    }

    static boolean allInfect() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
