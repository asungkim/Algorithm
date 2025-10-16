package Impl;

import java.util.Scanner;

public class BOJ_3085 {

    static int n;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                findPossible(i, j);
            }
        }

        System.out.println(max);
    }

    static void findPossible(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[x][y] != map[nx][ny]) {
                    swap(x, y, nx, ny);
                    max = Math.max(max, findLong(map));
                    swap(x, y, nx, ny);
                }
            }
        }
    }

    static void swap(int x, int y, int nx, int ny) {
        char tmp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = tmp;
    }

    static int findLong(char[][] tmp) {
        int max = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (tmp[i][j] == tmp[i][j - 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else cnt = 1;

            }
        }

        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (tmp[i][j] == tmp[i - 1][j]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else cnt = 1;

            }
        }

        return max;
    }
}
