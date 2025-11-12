package Impl;

import java.util.Scanner;

public class BOJ_14719 {

    static int h, w;
    static int[][] map;
    static int total = 0;
    static boolean[][] visited;

    /***
     * 1. 주어진 값을 통해 map을 완성
     * 2. 고이는 경우 -> 같은 높이 기준으로 0이 있는 부분이 앞뒤로 어디까지 0이 있는지 체크
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < w; i++) {
            int tmp = sc.nextInt();
            for (int j = 0; j < tmp; j++) {
                map[h - 1 - j][i] = 1;
            }
        }

        // 잠기는 기준
        // 같은 층에서 0덩어리가 1로 둘러싸여있나?

        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    check(i, j);
                }
            }
        }


        System.out.println(total);

//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void check(int x, int y) {
        int l = y, r = y;
        boolean lFind = false;
        boolean rFind = false;

        for (int i = y + 1; i < w; i++) {
            if (map[x][i] == 1) {
                r = i - 1;
                rFind = true;
                break;
            } else visited[x][i] = true;
        }

        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 1) {
                l = i + 1;
                lFind = true;
                break;
            } else visited[x][i] = true;
        }

        // 둘러싸여있지 않으면 물 못채움
        if (lFind && rFind) {
            for (int idx = l; idx <= r; idx++) {
                map[x][idx] = 1;
            }

            int cnt = r - l + 1;
            total += cnt;
        }
    }
}
