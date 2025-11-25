import java.io.IOException;
import java.util.*;

class Main {

    static int m, n, h;
    static int[][][] arr;
    static List<int[]> tList = new ArrayList<>();
    static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        arr = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = sc.nextInt();
                    if (arr[i][j][k] == 1) {
                        tList.add(new int[] { i, j, k, 0 });
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[h][n][m];

        for (int[] p : tList) {
            q.add(p);
            visited[p[0]][p[1]][p[2]] = true;
        }

        int max = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curTime = cur[3];

            max = Math.max(max, curTime);

            for (int i = 0; i < 6; i++) {
                int nh = cur[0] + dir[i][0];
                int nx = cur[1] + dir[i][1];
                int ny = cur[2] + dir[i][2];

                if (nx >= 0 && ny >= 0 && nh >= 0 && nh < h && nx < n && ny < m) {
                    if (!visited[nh][nx][ny] && arr[nh][nx][ny] == 0) {
                        visited[nh][nx][ny] = true;
                        arr[nh][nx][ny] = 1;
                        q.add(new int[] { nh, nx, ny, curTime + 1 });
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        if (max == -1) {
            return 0;
        } else
            return max;
    }

    private static void print() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}