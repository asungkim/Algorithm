package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11508_First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            arr[i] = c;
        }

        long sum = 0;

        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
            return;
        }

        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            if (i - 2 >= 0) {
                int three = arr[i] + arr[i - 1] + arr[i - 2];
                int min = Math.min(arr[i], Math.min(arr[i - 1], arr[i - 2]));
                sum += (three - min);
                i -= 2;
            } else {
                for (int j = i; j >= 0; j--) {
                    sum += arr[j];
                }
                break;
            }
        }

        System.out.println(sum);

    }
}
