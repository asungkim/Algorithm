import java.io.IOException;
import java.util.*;

class Main {

    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        cnt++;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}