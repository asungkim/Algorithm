import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] map;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        recur(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void recur(int r, int c, int size) {
        if (isSame(r, c, size)) {
            if (map[r][c] == 0) {
                white++;
            } else
                blue++;

            return;
        }

        int newSize = size / 2;
        recur(r, c, newSize);
        recur(r, c + newSize, newSize);
        recur(r + newSize, c, newSize);
        recur(r + newSize, c + newSize, newSize);
    }

    private static boolean isSame(int r, int c, int size) {
        int d = map[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (d != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}