import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;
    static int maxH = -1;
    static boolean[][] isWater;
    static boolean[][] visited;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                maxH = Math.max(maxH, arr[i][j]);
            }
        }

        for (int h = 0; h <= maxH; h++) {
            isWater = new boolean[n][n];
            visited = new boolean[n][n];
            pourWater(h);
            max = Math.max(max, findRealm());
        }

        System.out.println(max);
    }

    private static int findRealm() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isWater[i][j] && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
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

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && !isWater[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }

    private static void pourWater(int h) {
        // h보다 작거나 같으면 잠김
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= h) {
                    isWater[i][j] = true;
                }
            }
        }
    }
}