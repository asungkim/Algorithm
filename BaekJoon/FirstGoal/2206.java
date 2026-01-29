import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] arr;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = change(sc.nextLine());
        }

        System.out.println(bfs());

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    private static int[] change(String s) {
        char[] tmp = s.toCharArray();
        int[] an = new int[tmp.length];
        for (int i = 0; i < m; i++) {
            an[i] = tmp[i] - '0';
        }
        return an;
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        q.add(new int[] { 0, 0, 1, 0 });
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if ((cur[0] == n - 1) && (cur[1] == m - 1)) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny][cur[3]]) {
                        if (arr[nx][ny] == 0) {
                            visited[nx][ny][cur[3]] = true;
                            q.add(new int[] { nx, ny, cur[2] + 1, cur[3] });
                        } else {
                            if (cur[3] == 0) {
                                visited[nx][ny][1] = true;
                                q.add(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
                            }
                        }
                    }

                }
            }
        }

        return -1;

    }
}