package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 서류 순으로 정렬했을 때 일단 앞사람 통과
        // 뒷사람은 면접 성적으로 판단

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] rank = new int[n][2];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, (a, b) -> a[0] - b[0]);

            int cnt = 1;
            int min = rank[0][1];

            for (int j = 1; j < n; j++) {
                if (rank[j][1] < min) {
                    cnt++;
                    min = rank[j][1];
                }
            }

            System.out.println(cnt);

        }
    }
}
