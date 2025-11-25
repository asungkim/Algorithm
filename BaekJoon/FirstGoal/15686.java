import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static List<int[]> homeList = new ArrayList<>();
    static List<int[]> chickList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 치킨거리 = 집과 가장 가까운 치킨집 사이의 거리
        // 도시의 치킨거리 = 모든 집 치킨거리 합
        // 도시의 치킨거리 최소로

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    homeList.add(new int[] { i, j });
                }
                if (map[i][j] == 2) {
                    chickList.add(new int[] { i, j });
                }
            }
        }

        visited = new boolean[chickList.size()];

        // m=3
        // 치킨집중 i개 뽑아 -> 그걸로 도시의 치킨거리 구해 -> 최솟값 갱신

        dfs(0, 0);

        System.out.println(min);
    }

    private static int findGap(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private static int findCityDist() {
        int sum = 0;
        for (int[] homeP : homeList) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chickList.size(); i++) {
                if (visited[i]) {
                    minDist = Math.min(minDist, findGap(homeP, chickList.get(i)));
                }
            }
            sum += minDist;
        }

        return sum;
    }

    private static void dfs(int depth, int idx) {
        if (depth == m) {
            min = Math.min(min, findCityDist());
            return;
        }

        for (int i = idx; i < chickList.size(); i++) {
            int[] p = chickList.get(i);
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}