package Greedy;

import java.util.Scanner;

public class BOJ_20365_Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int b = 0, r = 0;
        char prev = 0;
        //

        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c != prev) {
                if (c == 'R') r++;
                else b++;
                prev = c;
            }
        }

        System.out.println(Math.min(b, r) + 1);
    }


}
