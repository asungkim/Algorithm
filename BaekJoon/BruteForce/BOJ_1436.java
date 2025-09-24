package BruteForce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start = 666;
        int cnt = 0;
        while (true) {
            if (cnt == n) {
                System.out.println(start - 1);
                return;
            }

            if (String.valueOf(start).contains("666")) {
                cnt++;
            }

            start++;
        }

    }
}
