package Greedy;

import java.util.*;

public class BOJ_19598 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else return a[0] - b[0];
        });


        PriorityQueue<Integer> endTimeRoomList = new PriorityQueue<>();
        endTimeRoomList.add(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            int curStart = arr[i][0];
            int curEnd = arr[i][1];

            if (curStart >= endTimeRoomList.peek()) {
                endTimeRoomList.poll();
            }
            endTimeRoomList.add(curEnd);
        }

        System.out.println(endTimeRoomList.size());


    }
}
