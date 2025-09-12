package Greedy;

import java.util.Scanner;

public class BOJ_20365_First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int cnt1 = getCnt(arr, 'B', 'R');
        int cnt2 = getCnt(arr, 'R', 'B');

        System.out.println(Math.min(cnt1, cnt2));
    }

    static int getCnt(char[] arr, char a, char b) {
        int n = arr.length;
        int s = -1, e = -1;

        // 시작점, 끝점 찾기
        for (int i = 0; i < n; i++) {
            if (arr[i] == a) {
                s = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == a) {
                e = i;
                break;
            }
        }

        if (s == -1) return 1;

        int allCnt = 1;

        for (int i = s; i <= e; i++) {
            if (arr[i] == b) {
                allCnt++;

                while (i + 1 <= e && arr[i + 1] == b) {
                    i++;
                }
            }
        }

        // 시작점 이전에 b가 있었는지
        boolean frontB = false;
        for (int i = 0; i < s; i++) {
            if (arr[i] == b) {
                frontB = true;
                break;
            }
        }

        // 끝점 이후에 b가 있었는지
        boolean backB = false;
        for (int i = e + 1; i < n; i++) {
            if (arr[i] == b) {
                backB = true;
                break;
            }
        }

        if (frontB && backB) allCnt += 2;
        else if (frontB || backB) allCnt += 1;
        // 둘 다 없으면 +0

        return allCnt;
    }
}
