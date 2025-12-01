import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] map;
    static int[] curP;
    static int curDir; // 0123 -> 북동남서
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] isClean;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        curP = new int[2];

        isClean = new boolean[n][m];

        for (int i = 0; i < 2; i++) {
            curP[i] = sc.nextInt();
        }
        curDir = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = run();

        System.out.println(answer);
    }

    private static int run() {
        int cnt = 0;
        while (true) {

            // 청소안됐으면 현재 청소
            if (!isClean[curP[0]][curP[1]]) {
                isClean[curP[0]][curP[1]] = true;
                cnt++;
            }

            if (hasCurBlankNotClean()) {
                curDir = (curDir + 3) % 4;
                int nx = curP[0] + dx[curDir];
                int ny = curP[1] + dy[curDir];
                if (blankNotClean(nx, ny)) {
                    curP[0] = nx;
                    curP[1] = ny;
                }

            } else {
                int backDir = (curDir + 2) % 4;
                int nx = curP[0] + dx[backDir];
                int ny = curP[1] + dy[backDir];

                if (!inMap() || map[nx][ny] == 1)
                    break;

                curP[0] = nx;
                curP[1] = ny;
            }
        }

        return cnt;
    }

    private static boolean blankNotClean(int x, int y) {
        // 맵안에 있는데
        if (inMap(x, y)) {
            // 청소되지않은 빈칸이면
            if (!isClean[x][y] && map[x][y] == 0) {
                return true;
            }
        }

        return false;
    }

    // 하나라도 청소할 수 있는 빈칸이 있으면 true
    private static boolean hasCurBlankNotClean() {
        for (int i = 0; i < 4; i++) {
            int nx = curP[0] + dx[i];
            int ny = curP[1] + dy[i];

            if (blankNotClean(nx, ny)) {
                return true;
            }
        }

        return false;
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}