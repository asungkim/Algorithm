package Impl;

import java.util.*;

public class BOJ_15683 {

    static int answer = 100;
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<int[]> cctvList = new ArrayList<>();
    static int cctvLen;
    static Map<Integer, List<int[]>> caseMap;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        cctvLen = cctvList.size();
        caseMap = makeMap();

        dfs(0);

        System.out.println(answer);

    }

    private static void dfs(int depth) {
        if (depth == cctvLen) {
            answer = Math.min(answer, zeroCnt());
            return;
        }

        int[] cctv = cctvList.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        for (int[] dir : caseMap.get(type)) {
            List<int[]> changeXY = checkMinus(x, y, dir);
            dfs(depth + 1);
            clear(changeXY);
        }
    }

    private static void clear(List<int[]> list) {
        for (int[] c : list) {
            map[c[0]][c[1]] = 0;
        }
    }

    private static List<int[]> checkMinus(int x, int y, int[] dir) {
        List<int[]> changed = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
                    if (map[nx][ny] == 6) break;
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = -1;
                        changed.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return changed;
    }

    private static int zeroCnt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static Map<Integer, List<int[]>> makeMap() {
        Map<Integer, List<int[]>> tmp = new HashMap<>();

        tmp.put(1, Arrays.asList(
                new int[]{1, 0, 0, 0},
                new int[]{0, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1}
        ));

        tmp.put(2, Arrays.asList(
                new int[]{1, 0, 1, 0},
                new int[]{0, 1, 0, 1}
        ));

        tmp.put(3, Arrays.asList(
                new int[]{1, 1, 0, 0},
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 0, 1}
        ));

        tmp.put(4, Arrays.asList(
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 1},
                new int[]{1, 1, 0, 1}
        ));

        tmp.put(5, Arrays.asList(
                new int[]{1, 1, 1, 1}
        ));

        return tmp;
    }
}
