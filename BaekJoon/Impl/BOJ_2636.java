package Impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2636 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int n, m;
    static int time = 0;
    static int[][] map;
    static int prev;
    static boolean[][] visited;
    static boolean[][] outside;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 외부와 노출이 되었냐 아니냐

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        while (true) {
            // 치즈가 모두 녹으면 끝
            int cnt = countCheese();
            if (cnt == 0) {
                break;
            }

            prev = cnt;
            time++;

            // 2. 녹은이후
            melt();
        }

        System.out.println(time);
        System.out.println(prev);
    }

    private static void melt() {
        visited = new boolean[n][m];
        outside = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1) {
                        outside[nx][ny] = true;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && outside[i][j]) {
                    map[i][j] = 0;
                }
            }
        }

    }


    private static int countCheese() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
