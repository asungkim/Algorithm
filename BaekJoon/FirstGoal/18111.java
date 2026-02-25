import java.io.IOException;
import java.util.*;

class Main {

    static int n, m, b;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        b = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int target = 0;

        for (int h = 0; h <= 256; h++) {
            int time = findTime(h);
            if (time != -1) {
                if (time < min || (time == min && h > target)) {
                    min = time;
                    target = h;
                }
            }
        }
    }

    private static int findTime(int h) {

    }
}