package BackTracking;


import java.util.Scanner;

public class BOJ_6603 {

    static int k;
    static int[] arr, list;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                return;
            }

            arr = new int[k];
            list = new int[6];
            sb = new StringBuilder();

            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }

            // arr 중에 6개 뽑기
            dfs(0, 0);

            System.out.println(sb);
        }


    }

    static void dfs(int depth, int idx) {
        if (depth == 6) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            list[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
