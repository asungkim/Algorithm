package Impl;


import java.util.*;

public class BOJ_5430 {

    static int n;
    static Deque<Integer> dq;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            char[] cmdArr = sc.next().toCharArray();
            n = sc.nextInt();
            split(sc.next());

            boolean isReverse = false; // 정방향
            boolean isError = false;
            for (int j = 0; j < cmdArr.length; j++) {
                if (cmdArr[j] == 'R') {
                    isReverse = !isReverse;
                } else if (cmdArr[j] == 'D') {
                    if (dq.size() == 0) {
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        dq.removeLast();
                    } else {
                        dq.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                // 정상적인 결과
                System.out.println(result(isReverse));
            }
        }
    }


    static String result(boolean isReverse) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (isReverse) {
            while (!dq.isEmpty()) {
                sb.append(dq.removeLast());
                if (!dq.isEmpty()) sb.append(",");
            }
        } else {
            while (!dq.isEmpty()) {
                sb.append(dq.removeFirst());
                if (!dq.isEmpty()) sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    static void split(String s) {
        dq = new ArrayDeque<>();

        s = s.replace("[", "").replace("]", "");
        if (s.isEmpty()) return;
        String[] arr = s.split(",");

        for (int i = 0; i < n; i++) {
            dq.add(Integer.parseInt(arr[i]));
        }

    }
}
