import java.io.IOException;
import java.util.*;

class Main {

    static int m, n;
    static int[][] map;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // [n][m]
        // 다익는 최수 일수
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        int maxDay = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curDay = cur[2];

            maxDay = Math.max(maxDay, curDay);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new int[] { nx, ny, curDay + 1 });
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }

        if (maxDay == -1) {
            return 0;
        } else
            return maxDay;
    }
}