import java.io.IOException;
import java.util.*;

class Main {

    static int r, c;
    static char[][] arr;
    static boolean[] alp = new boolean[27];
    static int max = -1;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = sc.next().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {
        alp[arr[x][y] - 'A'] = true;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!alp[arr[nx][ny] - 'A']) {
                    alp[arr[nx][ny] - 'A'] = true;
                    dfs(nx, ny, cnt + 1);
                    alp[arr[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}