package Impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13335 {

    static int n, w, l;

    /***
     * 순서가 중요하니까 -> 큐 사용할까?
     * 빈자리를 어떻게 표시하지? -> 0으로 채우자
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        w = sc.nextInt();
        l = sc.nextInt();

        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            truck.add(sc.nextInt());
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        // 0 0

        int time = 1;
        int totalW = 0;
        while (!bridge.isEmpty()) {
            time++;
            totalW += bridge.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + totalW <= l) {
                    totalW += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
