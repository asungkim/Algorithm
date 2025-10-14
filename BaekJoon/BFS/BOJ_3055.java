package BFS;

import java.beans.Visibility;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3055 {

    static int answer = -1;
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] end = {};

    static Queue<int[]> q;
    static Queue<int[]> water;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        visited = new boolean[r][c];

        q = new LinkedList<>();
        water = new LinkedList<>();


        for (int i = 0; i < r; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = arr[j];
                if (map[i][j] == 'S') {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }

                if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                }

                if (map[i][j] == 'D') {
                    end = new int[]{i, j};
                }
            }
        }

        bfs();

        if (answer == -1) {
            System.out.println("KAKTUS");
        } else System.out.println(answer);
    }

    static void bfs() {
        while (!q.isEmpty()) {

            // 물먼저
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                int[] cur = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = '*';
                            water.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] == 'D') {
                            answer = cur[2] + 1;
                            return;
                        }

                        if (!visited[nx][ny] && map[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
                }
            }

        }

    }
}
