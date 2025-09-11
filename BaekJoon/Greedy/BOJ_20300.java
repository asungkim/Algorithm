package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20300 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        long m;
        if (arr.length % 2 == 0) {
            m = -1;
            for (int i = 0, j = n - 1; i <= j; i++, j--) {
                long sum = arr[i] + arr[j];
                m = Math.max(m, sum);
            }
        } else {
            m = arr[n - 1];
            for (int i = 0, j = n - 2; i <= j; i++, j--) {
                long sum = arr[i] + arr[j];
                m = Math.max(m, sum);
            }
        }

        System.out.println(m);


    }
}
