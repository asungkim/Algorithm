package Greedy;

import java.util.Scanner;

public class BOJ_1080 {
    static int n, m;
    static int[][] a, b;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) a[i][j] = s.charAt(j) - '0';
        }
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) b[i][j] = s.charAt(j) - '0';
        }

        if (n < 3 || m < 3) {
            System.out.println(isSame() ? 0 : -1);
            return;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    flip(i, j);
                    answer++;
                }
            }
        }

        System.out.println(isSame() ? answer : -1);
    }

    static boolean isSame() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }

    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++)
            for (int j = y; j < y + 3; j++)
                a[i][j] = 1 - a[i][j];
    }
}