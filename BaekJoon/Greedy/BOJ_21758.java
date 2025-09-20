package Greedy;

import java.util.Scanner;

public class BOJ_21758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] leftSum = new int[n];
        leftSum[0] = arr[0];
        int[] rightSum = new int[n];
        rightSum[n - 1] = arr[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            leftSum[i] = leftSum[i - 1] + arr[i];
            rightSum[j] = rightSum[j + 1] + arr[j];
        }

        int leftMax = 0;
        for (int i = 1; i <= n - 2; i++) {
            int f = leftSum[n - 1] - leftSum[0] - (arr[i]);
            int s = leftSum[n - 1] - leftSum[i];
            leftMax = Math.max(leftMax, f + s);
        }

        int rightMax = 0;
        for (int i = n - 2; i >= 1; i--) {
            int f = rightSum[0] - rightSum[n - 1] - (arr[i]);
            int s = rightSum[0] - rightSum[i];
            rightMax = Math.max(rightMax, f + s);
        }

        int midMax = 0;
        for (int i = 1; i <= n - 2; i++) {
            int left = leftSum[i] - leftSum[0];
            int right = rightSum[i] - rightSum[n - 1];
            midMax = Math.max(midMax, left + right);
        }

        int max = Math.max(leftMax, Math.max(rightMax, midMax));

        System.out.println(max);
    }
}
