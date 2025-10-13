package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {

    static int[][] map;
    static boolean[][] visited;
    static int len;
    static int min = 0;
    static int[][] dir = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}};
    // 2,1 1,2 2,-1 1,-2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            len = sc.nextInt();
            map = new int[len][len];
            visited = new boolean[len][len];
            int curX = sc.nextInt();
            int curY = sc.nextInt();
            int wantX = sc.nextInt();
            int wantY = sc.nextInt();

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(curX, curY, 0));
            visited[curX][curY] = true;
            while (!q.isEmpty()) {
                Point cur = q.poll();

                if (cur.x == wantX && cur.y == wantY) {
                    min = cur.cnt;
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dir[j][0];
                    int ny = cur.y + dir[j][1];

                    if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny, cur.cnt + 1));
                        }
                    }
                }
            }

            System.out.println(min);

        }
    }

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
