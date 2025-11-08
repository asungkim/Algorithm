package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1092 {

    static int n, m;
    static int[] limit, box;
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        limit = new int[n];
        for (int i = 0; i < n; i++) {
            limit[i] = sc.nextInt();
        }

        m = sc.nextInt();
        box = new int[m];
        for (int i = 0; i < m; i++) {
            box[i] = sc.nextInt();
        }

        visited = new boolean[m];

        Arrays.sort(limit);
        Arrays.sort(box);

        // limit의 값보다 box가 무거우면 못옮김
        // box가 작거나 같으면 들수있음


        if (limit[n - 1] < box[m - 1]) {
            System.out.println(-1);
            return;
        }


        int cnt = 0;
        int time = 0;
        while (true) {
            if (cnt >= m) break;

            int idx = m - 1;
            for (int i = n - 1; i >= 0; i--) {
                int cur = limit[i];
                while (idx >= 0) {
                    if (!visited[idx] && cur >= box[idx]) {
                        visited[idx] = true;
                        idx--;
                        cnt++;
                        break;
                    } else {
                        idx--;
                    }
                }
            }


            time++;
        }


        System.out.println(time);
    }
}
