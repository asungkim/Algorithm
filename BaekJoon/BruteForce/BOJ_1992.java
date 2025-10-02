package BruteForce;

import java.util.Scanner;

public class BOJ_1992 {

    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }

        }

        check(0, 0, n);

        System.out.println(sb.toString());
    }

    static void check(int x, int y, int n) {
        if (isOkay(x, y, n)) {
            sb.append(arr[x][y]);
            return;
        }

        int small = n / 2;

        sb.append('(');

        check(x, y, small);
        check(x, y + small, small);
        check(x + small, y, small);
        check(x + small, y + small, small);

        sb.append(')');
    }

    static boolean isOkay(int x, int y, int n) {
        int tmp = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (tmp != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
