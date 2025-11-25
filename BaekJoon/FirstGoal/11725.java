import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static List<Integer>[] list;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        answer = new int[n + 1];
        visited = new boolean[n + 1];

        // 2부터 n까지
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        // for (int i = 1; i <= n; i++) {
        // System.out.print(i + " = ");
        // for (int p : list[i]) {
        // System.out.print(p + " ");
        // }
        // System.out.println();
        // }

        // 1 2 3 4 5 6 7
        // t

        find(1);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void find(int root) {
        visited[root] = true;

        for (int next : list[root]) {
            if (!visited[next]) {
                visited[next] = true;
                answer[next] = root;
                find(next);
            }
        }
    }
}