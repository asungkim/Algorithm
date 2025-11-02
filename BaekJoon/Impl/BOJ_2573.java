package Impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2573 {

    static int n, m;
    static int[][] map;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            int cnt = iceCnt();
            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            if (cnt >= 2) break;


            takeTime();
        }

        System.out.println(answer);
    }

    // 빙하 갯수
    private static int iceCnt() {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    // bfs 탐색하기
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                                if (!visited[nx][ny] && map[nx][ny] > 0) {
                                    visited[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                    cnt++;
                }
            }
        }

        return cnt;
    }


    private static void takeTime() {
        int[][] minus = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (map[nx][ny] == 0) {
                                cnt++;
                            }
                        }
                    }

                    int gap = map[i][j] - cnt;
                    minus[i][j] = Math.max(gap, 0);
                }
            }
        }

        map = minus;

        answer++;
    }
}
