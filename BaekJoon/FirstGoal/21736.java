import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static char[][] arr;
    static int x = 0, y = 0;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] tmp = sc.next().toCharArray();
            arr[i] = tmp;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        System.out.println(bfs(x, y));

    }

    private static String bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[] { a, b });
        visited[a][b] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && arr[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                        if (arr[nx][ny] == 'P') {
                            ans++;
                        }
                    }
                }
            }
        }

        if (ans == 0) {
            return "TT";
        } else
            return String.valueOf(ans);
    }
}