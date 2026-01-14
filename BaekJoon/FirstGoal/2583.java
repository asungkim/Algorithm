import java.io.IOException;
import java.util.*;

class Main {

    static int m, n, k;
    static int[][] map;
    static PriorityQueue<Integer> pq;

    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        // map[i][j] -> i,j ~ i+1,j+1 색칠

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // (0,2) ~ (4,4)

            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }
        pq = new PriorityQueue<>();

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    pq.add(bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        cnt++;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }

        return cnt;
    }
}