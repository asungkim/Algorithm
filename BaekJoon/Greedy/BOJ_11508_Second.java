package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11508_Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            arr[i] = c;
        }

        long sum = 0;

        Arrays.sort(arr);


        for (int i = n - 1, cnt = 1; i >= 0; i--, cnt++) {
            if (cnt % 3 == 0) continue;
            sum += arr[i];
        }

        System.out.println(sum);

    }
}
