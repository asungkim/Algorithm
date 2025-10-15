package Impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966 {

    static int n, m;
    static int[] imp;
    static Queue<Work> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            n = sc.nextInt(); // 문서 개수
            m = sc.nextInt(); // 현재 몇번째

            imp = new int[n];
            for (int j = 0; j < n; j++) {
                imp[j] = sc.nextInt();
            }

            int cnt = find();
            if (cnt != -1) {
                System.out.println(cnt);
            }
        }

    }

    static int find() {
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(new Work(i, imp[i]));
        }

        // Work num 이 m인게 몇번째에 출력될까
        int cnt = 1;
        while (!q.isEmpty()) {
            Work first = q.poll();

            if (hasMoreImp(first)) {
                q.offer(first);
            } else {
                if (first.num == m) {
                    return cnt;
                } else {
                    cnt++;
                }
            }
        }

        return -1;
    }

    static boolean hasMoreImp(Work w) {
        // 이 일보다 중요도가 높은 문서를 발견하면 true
        for (Work tmp : q) {
            if (w.num != tmp.num) {
                if (w.imp < tmp.imp) {
                    return true;
                }
            }
        }

        return false;
    }


    static class Work {
        int num, imp;

        public Work(int num, int imp) {
            this.num = num;
            this.imp = imp;
        }
    }
}
