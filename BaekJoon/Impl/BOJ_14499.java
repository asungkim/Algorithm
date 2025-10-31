package Impl;

import java.util.Scanner;

public class BOJ_14499 {

    static int n, m, x, y, k;
    static int[][] map;

    // 동서북남
    static int[][] dirArr = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    // 123456 위 뒤 오 왼 앞 아래
    static int[] dice = new int[7];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        k = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int cmd = sc.nextInt();
            if (canMove(cmd)) {
                roll(cmd);
            }
        }
    }

    private static void roll(int cmd) {
        switch (cmd) {
            case 1: {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            }
            case 2: {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            }
            case 3: {
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            }
            case 4: {
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
            }
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[1]);
    }

    private static boolean canMove(int cmd) {
        int idx = cmd - 1;
        int nx = x + dirArr[idx][0];
        int ny = y + dirArr[idx][1];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            x = nx;
            y = ny;
            return true;
        }

        return false;
    }

}
