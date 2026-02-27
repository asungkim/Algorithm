import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[][] map;
    static Pipe start = new Pipe(new Point(1, 1), new Point(1, 2), 0);
    static int answer = 0;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1)
                    continue;

                if (j - 1 >= 1) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                }
                if (i - 1 >= 1) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }
                if (i - 1 >= 1 && j - 1 >= 1) {
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);

        // dfs(start);

        // System.out.println(answer);
    }

    private static void dfs(Pipe p) {
        if (p.b.x == n && p.b.y == n) {
            answer++;
            return;
        }

        if (p.dir == 0) {
            if (p.b.y + 1 <= n && map[p.b.x][p.b.y + 1] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x, p.b.y + 1), 0));
            }
            if (p.b.x + 1 <= n && p.b.y + 1 <= n && map[p.b.x + 1][p.b.y + 1] != 1 && map[p.b.x][p.b.y + 1] != 1
                    && map[p.b.x + 1][p.b.y] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x + 1, p.b.y + 1), 2));
            }
        } else if (p.dir == 1) {
            if (p.b.x + 1 <= n && map[p.b.x + 1][p.b.y] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x + 1, p.b.y), 1));
            }
            if (p.b.x + 1 <= n && p.b.y + 1 <= n && map[p.b.x + 1][p.b.y + 1] != 1 && map[p.b.x][p.b.y + 1] != 1
                    && map[p.b.x + 1][p.b.y] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x + 1, p.b.y + 1), 2));
            }
        } else {
            if (p.b.y + 1 <= n && map[p.b.x][p.b.y + 1] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x, p.b.y + 1), 0));
            }
            if (p.b.x + 1 <= n && map[p.b.x + 1][p.b.y] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x + 1, p.b.y), 1));
            }
            if (p.b.x + 1 <= n && p.b.y + 1 <= n && map[p.b.x + 1][p.b.y + 1] != 1 && map[p.b.x][p.b.y + 1] != 1
                    && map[p.b.x + 1][p.b.y] != 1) {
                dfs(new Pipe(p.b, new Point(p.b.x + 1, p.b.y + 1), 2));
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pipe {
        Point f, b;
        int dir;

        public Pipe(Point f, Point b, int dir) {
            this.f = f;
            this.b = b;
            this.dir = dir;
        }
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}