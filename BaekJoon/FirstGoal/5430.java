import java.io.IOException;
import java.util.*;

class Main {

    static Deque<Integer> dq;
    static char[] cmds;
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            cmds = sc.next().toCharArray();
            n = sc.nextInt();
            nums = parse(sc.next());
            dq = new ArrayDeque<>();
            for (int tmp : nums)
                dq.add(tmp);

            String result = AC();
            System.out.println(result);
        }

    }

    private static String AC() {
        boolean isRight = true;

        for (char cmd : cmds) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            } else if (cmd == 'D') {
                if (dq.size() == 0) {
                    return "error";
                } else {
                    if (isRight) {
                        dq.removeFirst();
                    } else {
                        dq.removeLast();
                    }
                }
            }
        }

        return makeString(isRight);
    }

    private static String makeString(boolean isRight) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (dq.isEmpty()) {
            sb.append("]");
            return sb.toString();
        }

        if (isRight) {
            sb.append(dq.removeFirst());
            while (!dq.isEmpty()) {
                sb.append(",").append(dq.removeFirst());
            }

        } else {
            sb.append(dq.removeLast());
            while (!dq.isEmpty()) {
                sb.append(",").append(dq.removeLast());
            }
        }
        sb.append("]");

        return sb.toString();
    }

    private static int[] parse(String s) {
        String tmp = s.substring(1, s.length() - 1);
        if (tmp.length() == 0)
            return new int[] {};

        String[] arr = tmp.split(",");
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.valueOf(arr[i]);
        }

        return result;
    }
}