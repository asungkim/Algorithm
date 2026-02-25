import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1 2 3 4 5 6 7
        //

        int l = 0;
        int answer = 0;
        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            answer = Math.max(answer, r - l + 1);
        }

        System.out.println(answer);
    }
}