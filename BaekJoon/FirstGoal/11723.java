import java.io.IOException;
import java.util.*;

class Main {

    static int m;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        m = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] arr = sc.nextLine().split(" ");
            if (arr.length == 2) {
                int x = Integer.valueOf(arr[1]);
                if (arr[0].equals("add")) {
                    set.add(x);
                } else if (arr[0].equals("remove")) {
                    if (set.contains(x)) {
                        set.remove(x);
                    }
                } else if (arr[0].equals("check")) {
                    if (set.contains(x)) {
                        sb.append("1\n");
                    } else
                        sb.append("0\n");
                } else if (arr[0].equals("toggle")) {
                    if (set.contains(x)) {
                        set.remove(x);
                    } else
                        set.add(x);
                }
            } else {
                if (arr[0].equals("all")) {
                    set = new HashSet<>();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                } else if (arr[0].equals("empty")) {
                    set.clear();
                }
            }
        }

        System.out.println(sb.toString());
    }

}