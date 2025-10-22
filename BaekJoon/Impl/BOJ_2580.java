package Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2580 {

    static int[][] map;
    static List<int[]> emptyList = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) emptyList.add(new int[]{i, j});
            }
        }

        dfs(0);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (solved) return;

        if (depth == emptyList.size()) {
            print();
            solved = true;
            return;
        }

        int[] blank = emptyList.get(depth);
        int x = blank[0], y = blank[1];
        for (int i = 1; i <= 9; i++) {
            if (isOkay(x, y, i)) {
                map[x][y] = i;
                dfs(depth + 1);
                map[x][y] = 0;
            }
        }
    }

    private static boolean isOkay(int x, int y, int num) {
        // 같은 숫자가 있으면 안됨
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num || map[i][y] == num) return false;
        }

        // 3x3 체크 (4,5)
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;
        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
