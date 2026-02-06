import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        checkParent(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void checkParent(int p) {
        visited[p] = true;

        for (int child : list[p]) {
            if (!visited[child]) {
                parent[child] = p;
                checkParent(child);
            }
        }
    }
}