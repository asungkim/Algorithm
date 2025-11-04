package Impl;

import java.util.*;

public class BOJ_14891 {

    static int[][] list = new int[4][8];
    static int[] scoreS = {1, 2, 4, 8};
    static int k, totalScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < 8; j++) {
                list[i][j] = tmp[j] - '0';
            }
        }

//        for (int i=0;i<4;i++) {
//            for (int j=0;j<8;j++) {
//                System.out.print(list[i][j]+" ");
//            }
//            System.out.println();
//        }


        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int idx = sc.nextInt() - 1;
            int dir = sc.nextInt();

            allRoll(idx, dir);
        }

        for (int j = 0; j < 4; j++) {
            if (list[j][0] == 1) {
                totalScore += scoreS[j];
            }
        }

        System.out.println(totalScore);
    }

    private static void allRoll(int idx, int dir) {
        leftWork(idx - 1, (-1) * dir);
        rightWork(idx + 1, (-1) * dir);
        roll(idx, dir);
    }

    private static void leftWork(int idx, int dir) {
        if (idx < 0) return;
        if (list[idx][2] == list[idx + 1][6]) return;
        leftWork(idx - 1, (-1) * dir);
        roll(idx, dir);
    }

    private static void rightWork(int idx, int dir) {
        if (idx > 3) return;
        if (list[idx][6] == list[idx - 1][2]) return;
        rightWork(idx + 1, (-1) * dir);
        roll(idx, dir);
    }

    private static void roll(int idx, int dir) {
        if (dir == 1) {
            int tmp = list[idx][7];
            for (int i = 7; i > 0; i--) {
                list[idx][i] = list[idx][i - 1];
            }
            list[idx][0] = tmp;

        } else {
            int tmp = list[idx][0];
            for (int i = 0; i < 7; i++) {
                list[idx][i] = list[idx][i + 1];
            }
            list[idx][7] = tmp;
        }
    }
}
