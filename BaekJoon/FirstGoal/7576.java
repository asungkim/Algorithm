import java.io.IOException;
import java.util.*;

class Main {

    static int m, n;
    static int[][] arr;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        System.out.println(bfs());

    }

    private static boolean isDone() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private static int bfs() {
        if (isDone()) {
            return 0;
        }

        int max = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            max = Math.max(max, cur[2]);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.add(new int[] { nx, ny, cur[2] + 1 });
                    }
                }
            }
        }

        if (isDone()) {
            return max;
        } else
            return -1;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}