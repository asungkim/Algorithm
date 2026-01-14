import java.io.IOException;
import java.util.*;

class Main {

    static int[] arr;
    static int k;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0)
                break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            answer = new int[6];

            dfs(0, 0);
            System.out.println();
        }
    }

    // arr중에 6개 뽑기
    private static void dfs(int depth, int idx) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < k; i++) {
            answer[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

}