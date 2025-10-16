package Impl;

import java.util.*;

public class BOJ_2108 {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n 홀수

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(avg());
        System.out.println(mid());
        System.out.println(cnt());
        System.out.println(range());

    }

    static int avg() {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];

        double avg = sum / n;
        return (int) Math.round(avg);
    }

    static int mid() {
        return arr[arr.length / 2];
    }

    static int cnt() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxCnt = 0;
        for (int value : map.values()) {
            maxCnt = Math.max(maxCnt, value);
        }

        List<Integer> tmp = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCnt) {
                tmp.add(key);
            }
        }

        if (tmp.size() == 1) {
            return tmp.get(0);
        }

        Collections.sort(tmp);
        return tmp.get(1);
    }

    static int range() {
        if (arr.length == 1) {
            return 0;
        }

        return arr[arr.length - 1] - arr[0];
    }
}
