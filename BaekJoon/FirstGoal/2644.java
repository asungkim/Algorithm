import java.io.IOException;
import java.util.*;

class Main {

    static int n, a, b, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            // x는 y의 부모
            int x = sc.nextInt();
            int y = sc.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        // 1-2,3
        // 2-7,8,9
        // 4-5,6
        dfs(a, b, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

}