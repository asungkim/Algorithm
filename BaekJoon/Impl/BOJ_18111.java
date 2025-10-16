package Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_18111 {

    static int n, m, b;
    static int[][] map;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 제거 2 쌓기 1
        n = sc.nextInt();
        m = sc.nextInt();
        b = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        int minTime = Integer.MAX_VALUE;
        int rightH = 0;

        for (int i = 0; i <= 256; i++) {
            int time = calTime(i);
            if (time != -1) {
                if (time < minTime || (time == minTime && i > rightH)) {
                    minTime = time;
                    rightH = i;
                }
            }
        }

        System.out.println(minTime + " " + rightH);

    }

    static int calTime(int want) {
        int time = 0;
        int h = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = map[i][j];
                int gap = Math.abs(cur - want);
                if (gap == 0) continue;

                if (cur > want) {
                    h += gap;
                    time += (2 * gap);
                } else {
                    h -= gap;
                    time += gap;
                }
            }
        }

        if (h < 0) return -1;

        return time;
    }
}
