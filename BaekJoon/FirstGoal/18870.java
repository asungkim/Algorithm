import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int[] cArr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        cArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            cArr[i] = arr[i];
        }

        Arrays.sort(cArr);
        int start = 0;
        for (int tmp : cArr) {
            if (!map.containsKey(tmp)) {
                map.put(tmp, start);
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int tmp : arr) {
            sb.append(map.get(tmp)).append(" ");
        }

        System.out.println(sb.toString());
    }
}