package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new int[]{s, e});
        }

        Collections.sort(list, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else return a[1] - b[1];
        });

        //

        int cnt = 0;
        int p = -1;

        for (int i = 0; i < list.size(); i++) {
            int[] set = list.get(i);
            if (set[0] >= p) {
                p = set[1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
