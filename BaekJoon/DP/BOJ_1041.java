package DP;

import java.util.Scanner;

public class BOJ_1041 {

    static long n;
    static int[] arr;
    static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }

        long one = Long.MAX_VALUE;
        long two = Long.MAX_VALUE;
        long three = 0;
        long max = 0;
        long sum = 0;

        for (int i = 0; i < 6; i++) {
            one = Math.min(one, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + j != 5 && i != j)
                    two = Math.min(two, arr[i] + arr[j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            three += Math.min(arr[i], arr[5 - i]);
        }
        if (n == 1) {
            answer = sum - max;
        } else {

            answer = three * 4 + two * (4 * (n - 1) + 4 * (n - 2)) + one * ((n - 2) * (n - 1) * 4 + (n - 2) * (n - 2));
        }
        System.out.println(answer);

    }
}
