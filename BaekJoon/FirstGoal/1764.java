import java.io.IOException;
import java.util.*;

class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        Set<String> noListen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            noListen.add(sc.next());
        }

        PriorityQueue<String> list = new PriorityQueue<>();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            if (noListen.contains(name)) {
                cnt++;
                list.add(name);
            }
        }

        System.out.println(cnt);
        while (!list.isEmpty()) {
            System.out.println(list.poll());
        }
    }
}