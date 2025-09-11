package Greedy;

import java.util.Scanner;

public class BOJ_1343_Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (true) {
            if (idx == arr.length) {
                System.out.println(sb.toString());
                return;
            }

            if (arr[idx] == 'X') {
                int cnt = 0;

                // idx를 기점으로 X가 몇개 연속 나오는지 체크
                for (int i = idx; i < arr.length; i++) {
                    if (arr[i] == 'X') {
                        cnt++;
                    } else break;
                }

                if (cnt % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                idx += cnt;

                while (true) {
                    if (cnt < 4) break;

                    sb.append("AAAA");
                    cnt -= 4;
                }

                while (true) {
                    if (cnt < 2) break;
                    sb.append("BB");
                    cnt -= 2;
                }

            } else {
                sb.append(".");
                idx++;
            }
        }
    }
}
