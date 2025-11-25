import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static char[][] arr1;
    static char[][] arr2;
    static boolean[][] check1;
    static boolean[][] check2;

    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    static int cnt1 = 0, cnt2 = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr1 = new char[n][n];

        check1 = new boolean[n][n];
        check2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.next().toCharArray();
        }

        arr2 = copyArr(arr1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i][j] == 'G') {
                    arr2[i][j] = 'R';
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(arr2[i][j] + " ");
        // }
        // System.out.println();
        // }

        cnt1 = findCnt(check1, arr1);
        cnt2 = findCnt(check2, arr2);

        System.out.println(cnt1 + " " + cnt2);
    }

    private static char[][] copyArr(char[][] arr) {
        char[][] tmp = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        return tmp;
    }

    private static int findCnt(boolean[][] visited, char[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited, map);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void bfs(int x, int y, boolean[][] visited, char[][] map) {
        char color = map[x][y];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == color) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}