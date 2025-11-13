import java.io.IOException;
import java.util.*;

class Main {

    static int n,m,v;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        v=sc.nextInt();

        map=new int[n+1][n+1];

        for (int i=0;i<m;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt(); 

            map[a][b]=1;
            map[b][a]=1;
        }



        visited=new boolean[n+1];
        dfs(v);
        sb.append("\n");
        visited=new boolean[n+1];
        bfs(v);

        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        visited[start]=true;
        sb.append(start+" ");

        for (int i=1;i<=n;i++) {
            if (!visited[i] && map[start][i]!=0) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while (!q.isEmpty()) {
            int cur=q.poll();
            sb.append(cur+" ");

            for (int i=1;i<=n;i++) {
                if (!visited[i] && map[cur][i]!=0) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}