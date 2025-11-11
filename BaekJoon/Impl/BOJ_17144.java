package Impl;

import java.util.Scanner;

public class BOJ_17144 {

    static int r, c, t;
    static int[][] map;
    static int time = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[] up = new int[2];
    static int[] down = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == -1) {
                    up[0] = i - 1;
                    down[0] = i;
                }
            }
        }

        while (true) {
            if (time == t) {
                break;
            }

            dustBlow();
            airWork();

            time++;
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    private static void dustBlow() {
        int[][] add = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 미세먼지가 있으면
                if (map[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                            if (map[nx][ny] != -1) {
                                add[nx][ny] += (map[i][j] / 5);
                                cnt++;
                            }
                        }
                    }

                    map[i][j] -= (map[i][j] / 5) * cnt;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += add[i][j];
            }
        }
    }

    private static void airWork() {
        // 1. 오 벽 위 벽 왼 벽 아래
        int s = up[0];
        int e = down[0];
        for (int i = s - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < s; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[s][i] = map[s][i - 1];
        }
        map[s][1] = 0;

        for (int i = e + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        for (int i = r - 1; i > e; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[e][i] = map[e][i - 1];
        }
        map[e][1] = 0;

    }
}
