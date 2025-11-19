import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static boolean[] visited;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new HashMap<>();

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            map.get(u).add(v);
            map.get(v).add(u);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                run(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void run(int start) {
        visited[start] = true;

        for (int next : map.get(start)) {
            if (!visited[next]) {
                run(next);
            }
        }
    }
}