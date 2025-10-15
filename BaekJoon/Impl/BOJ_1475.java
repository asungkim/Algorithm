package Impl;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475 {

    static int[] set;
    static int cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] arr = sc.next().toCharArray();
        set = new int[10]; // 0~9
        Arrays.fill(set, 1);

        cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i] - '0';
            if (set[cur] == 0) {
                if (cur == 6 && set[9] >= 1) {
                    set[9]--;
                } else if (cur == 9 && set[6] >= 1) {
                    set[6]--;
                } else {
                    setFill();
                    set[cur]--;
                }
            } else {
                set[cur]--;
            }
        }


        System.out.println(cnt);
    }

    static void setFill() {
        for (int i = 0; i < set.length; i++) {
            set[i]++;
        }
        cnt++;
    }
}
