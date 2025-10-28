package Impl;

import java.util.*;

public class BOJ_16234 {

    static int n, l, r;
    static int[][] map;
    static int answer = 0;
    static boolean[][] visited;
    static List<int[]> list;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        while (true) {
            boolean canMove = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = check(i, j);
                        if (list.size() > 1) {
                            changeMap(sum);
                            canMove = true;
                        }
                    }
                }
            }

            if (!canMove) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    private static void changeMap(int sum) {
        for (int[] arr : list) {
            map[arr[0]][arr[1]] = sum / list.size();
        }
    }

    private static int check(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        list = new ArrayList<>();
        list.add(new int[]{x, y});

        int sum = map[x][y];
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int gap = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
                    if (!visited[nx][ny] && gap >= l && gap <= r) {
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                        list.add(new int[]{nx, ny});
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return sum;
    }

}
