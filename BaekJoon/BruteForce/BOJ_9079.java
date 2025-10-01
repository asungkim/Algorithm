package BruteForce;

import java.util.*;

public class BOJ_9079 {

    static int[][] option = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String[][] arr = new String[3][3];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = sc.next();
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (arr[j][k].equals("H")) {
                        sb.append(1);
                    } else if (arr[j][k].equals("T")) {
                        sb.append(0);
                    }
                }
            }


            int min = bfs(sb.toString());
            System.out.println(min);
        }
    }

    static int bfs(String start) {
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Node(start, 0));
        visited.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            String curStr = cur.str;
            int curCnt = cur.cnt;

            if (isOkay(curStr)) {
                return curCnt;
            }

            for (int[] op : option) {
                String nextStr = flip(curStr, op);
                if (!visited.contains(nextStr)) {
                    visited.add(nextStr);
                    q.add(new Node(nextStr, curCnt + 1));
                }
            }

        }

        return -1;
    }

    static String flip(String str, int[] op) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < op.length; i++) {
            arr[op[i]] = (arr[op[i]] == '1') ? '0' : '1';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }


    static boolean isOkay(String s) {
        char f = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != f) {
                return false;
            }
        }

        return true;
    }

    static class Node {
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
