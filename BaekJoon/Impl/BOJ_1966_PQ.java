package Impl;

import java.util.*;

public class BOJ_1966_PQ {

    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt(); // 문서 개수
            m = sc.nextInt(); // 현재 몇번째

            Queue<Work> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                int imp = sc.nextInt();
                q.offer(new Work(j, imp));
                pq.offer(imp);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Work cur = q.poll();

                if (cur.imp == pq.peek()) {
                    pq.poll();
                    cnt++;
                    if (cur.num == m) {
                        System.out.println(cnt);
                        break;
                    }
                } else {
                    q.offer(cur);
                }
            }
        }

    }


    static class Work {
        int num, imp;

        public Work(int num, int imp) {
            this.num = num;
            this.imp = imp;
        }
    }
}
