package Impl;

import java.util.Scanner;

public class BOJ_14503 {

    static int n, m;
    static int x, y, d;
    static int[][] map;
    static boolean[][] cleaned;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        cleaned = new boolean[n][m];

        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt(); // 0,1,2,3 북동남서

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                // 0이면 빈칸, 1이면 벽
            }
        }

        while (true) {
            cleaned[x][y] = true;

            if (!hasNoCleanBlank()) {
                int fakeD = (d + 2) % 4;
                int nx = x + dir[fakeD][0];
                int ny = y + dir[fakeD][1];

                if (isInMap(nx, ny) && map[nx][ny] != 1) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }

            } else {
                d = (d + 3) % 4; // 반시계 회전
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if (noCleanBlank(nx,ny)) {
                    x = nx;
                    y = ny;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cleaned[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean isInMap(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    static boolean noCleanBlank(int nx, int ny) {
        return map[nx][ny] == 0 && !cleaned[nx][ny];
    }

    static boolean hasNoCleanBlank() {
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (isInMap(nx, ny)) {
                if (noCleanBlank(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}
