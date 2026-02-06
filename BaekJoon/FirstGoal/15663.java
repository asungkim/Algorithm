import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr, tmp;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        set = new HashSet<>();

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : tmp) {
                sb.append(num).append(" ");
            }
            String s = sb.toString();

            if (!set.contains(s)) {
                System.out.println(s);
                set.add(s);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}