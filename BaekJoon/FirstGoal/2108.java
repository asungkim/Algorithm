import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int[] arr;
    static int sum = 0;
    static Map<Integer, Integer> cntMap;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        cntMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);
        int avg = (int) Math.round((double) sum / n);
        int mid = arr[n / 2];

        for (int value : cntMap.values()) {
            max = Math.max(max, value);
        }
        List<Integer> list = new ArrayList<>();

        for (int key : cntMap.keySet()) {
            if (cntMap.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        int three = list.size() >= 2 ? list.get(1) : list.get(0);
        int range = arr[n - 1] - arr[0];

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(three);
        System.out.println(range);
    }
}