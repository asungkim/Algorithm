package Greedy;

import java.util.Scanner;

public class BOJ_11501 {

    static int n;
    static int[] price;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            price = new int[n];

            for (int j = 0; j < n; j++) {
                price[j] = sc.nextInt();
            }

            System.out.println(bestProfit());
        }
    }

    static long bestProfit() {
        long sum = 0;
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (price[i] > max) {
                max = price[i];
            } else {
                sum += (max - price[i]);
            }
        }

        return sum;
    }
}
