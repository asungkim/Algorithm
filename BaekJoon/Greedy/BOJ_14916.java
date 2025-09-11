package Greedy;

import java.util.Scanner;

public class BOJ_14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }

        // 5원으로 최대로 쓰
        int a = n / 5;
        int b;
        int rest = n - (a * 5);
        if (rest % 2 == 0) {
            b = rest / 2;
        } else {
            a -= 1;
            b = (rest + 5) / 2;
        }

        System.out.println(a + b);

    }
}
