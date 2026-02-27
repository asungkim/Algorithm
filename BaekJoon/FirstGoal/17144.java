import java.io.IOException;
import java.util.*;

class Main {

    static int r, c, t;
    static int[][] map;
    static List<int[]> list = new ArrayList<>();

    static int[] up = new int[2];
    static int[] down = new int[2];

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();

        map = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1 && up[0] == 0) {
                    up[0] = i;
                    up[1] = j;
                    down[0] = i + 1;
                    down[1] = j;
                }
                if (map[i][j] > 0) {
                    list.add(new int[] { i, j });
                }
            }
        }

        for (int i = 0; i < t; i++) {
            blow();
            cleanUp();
            cleanDown();
        }

        System.out.println(count());
    }

    private static void blow() {
        int[][] tmp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    int data = map[i][j] / 5;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 1 && ny >= 1 && nx <= r && ny <= c) {
                            if (map[nx][ny] != -1) {
                                tmp[nx][ny] += data;
                                cnt++;
                            }
                        }
                    }

                    tmp[i][j] -= (cnt * data);
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }

    private static void cleanUp() {
        // 위->아래
        for (int i = up[0] - 1; i >= 2; i--) {
            map[i][1] = map[i - 1][1];
        }

        // 왼<-오
        for (int i = 2; i <= c; i++) {
            map[1][i - 1] = map[1][i];
        }

        // // 아래->위
        for (int i = 2; i <= up[0]; i++) {
            map[i - 1][c] = map[i][c];
        }

        // // 왼->오
        for (int i = c; i >= 2; i--) {
            map[up[0]][i] = map[up[0]][i - 1];
        }

        map[up[0]][2] = 0;
    }

    private static void cleanDown() {

        for (int i = down[0] + 1; i < r; i++) {
            map[i][1] = map[i + 1][1];
        }

        for (int i = 1; i < c; i++) {
            map[r][i] = map[r][i + 1];
        }

        for (int i = r - 1; i >= down[0]; i--) {
            map[i + 1][c] = map[i][c];
        }

        for (int i = c - 1; i >= 1; i--) {
            map[down[0]][i + 1] = map[down[0]][i];
        }

        map[down[0]][2] = 0;
    }

    private static void print() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int count() {
        int total = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] > 0) {
                    total += map[i][j];
                }
            }
        }

        return total;
    }
}