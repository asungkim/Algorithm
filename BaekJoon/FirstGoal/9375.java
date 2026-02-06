import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();

            map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String name = sc.next();
                String type = sc.next();

                map.put(type, map.getOrDefault(type, 0) + 1);

            }

            int total = 1;
            for (int v : map.values()) {
                total *= (v + 1);
            }

            System.out.println(total - 1);
        }

    }
}