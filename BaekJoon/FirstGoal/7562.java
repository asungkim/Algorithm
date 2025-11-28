import java.io.IOException;
import java.util.*;

class Main {

    static int l;
    static int[][] map;
    static int[] start;
    static int[] end;
    static boolean[][] visited;
    static int[][] dir = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            l = sc.nextInt();
            map = new int[l][l];

            start = new int[3];
            end = new int[3];
            for (int j = 0; j < 2; j++)
                start[j] = sc.nextInt();
            for (int j = 0; j < 2; j++)
                end[j] = sc.nextInt();

            visited = new boolean[l][l];
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curCnt = cur[2];

            if (cur[0] == end[0] && cur[1] == end[1]) {
                return curCnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny, curCnt + 1 });
                    }
                }
            }
        }

        return -1;
    }
}