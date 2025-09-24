package BruteForce;

import java.util.Scanner;

public class BOJ_15721 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int t = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[20000];
        int idx = 0;
        int round = 1;

        while (true) {
            if (idx>=13000) break;
            int[] base = {0, 1, 0, 1};
            for (int v : base) {
                arr[idx++] = v;
            }

            // 반복 구간
            for (int i = 0; i < round + 1; i++) arr[idx++] = 0; // 뻔
            for (int i = 0; i < round + 1; i++) arr[idx++] = 1; // 데기

            round++;
        }

        // t번째 x를 찾는다
        int count = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] == x) {
                count++;
                if (count == t) {
                    System.out.println(i % a);
                    return;
                }
            }
        }
    }


}
