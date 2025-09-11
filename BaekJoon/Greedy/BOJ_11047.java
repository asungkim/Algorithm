package Greedy;

import java.util.Scanner;

public class BOJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > k) continue;
            cnt += (k / arr[i]);
            k %= arr[i];
            if (k == 0) break;
        }

        System.out.println(cnt);
    }
}
