import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class h{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static ArrayList<ArrayList<Integer>> tree, list, list2;
    static boolean vis[];
    static int cnt[], size[], bad[], a[];
    public static void solve(){
        int n = fr.nextInt();
        tree= new ArrayList<>();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
            list.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        vis = new boolean[n+1];
        cnt = new int[n+1];
        size = new int[n+1];
        bad = new int[n+1];
        a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = fr.nextInt();
            a[i] %= 2;
        }
        for(int i=1;i<n;i++){
            int u = fr.nextInt();
            int v = fr.nextInt();

            tree.get(u).add(v);
            tree.get(v).add(u);
            cnt[u]+=a[v];
            cnt[v]+=a[u];
            if(a[u]==1 && a[v]==0) list.get(u).add(v);
            if(a[v]==1 && a[u]==0) list.get(v).add(u);
        }
        // for(int i=1;i<=n;i++){
        //     fw.println(a[i] + " " + cnt[i]);
        // }
        for(int i=1;i<=n;i++){
            if(a[i]==0 && cnt[i]==0){
                fw.println("NO");
                return;
            }
        }
        for(int i=1;i<=n;i++){
            if(a[i] == 1 && !vis[i]){
                dfs(i, -1);
                if(size[i] % 2 == 0){
                    fw.println("NO");
                    return;
                }
            }
        }
        boolean even[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(a[i]==1 && bad[i]==0){
                q.add(i);
            }
        }
        fw.println("YES");
        for(int i=1;i<=n;i++){
            if(a[i]==0){
                if(cnt[i] % 2 == 1) fw.print(i + " ");
                else even[i] = true;
            }
            
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            fw.print(cur + " ");
            for(int i : list2.get(cur)){
                bad[i]--;
                if(bad[i]==0)q.add(i);
            }
            for(int i : list.get(cur)){
                if(even[i]){ fw.print(i + " "); even[i] = false;}
            }
        }
        fw.println("");
    }
    public static void dfs(int node, int par){
        size[node] = 1;
        vis[node] = true;
        for(int i : tree.get(node)) if(i != par && a[i]==1){
            dfs(i, node);

            if(size[i] % 2 == 0){
                bad[node]++;
                list2.get(i).add(node);
            }
            else{
                bad[i]++;
                list2.get(node).add(i);
            }
            size[node] += size[i];
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int t = fr.nextInt();
        //System.out.println(solve());
        //System.out.println(solve()?"YES":"NO");
        u:while(t-->0){
            solve();
            //System.out.println(solve()?"YES":"NO");
        }
        fw.flush();
        //System.out.println(((long)System.nanoTime()-start)/1000000);
    }
}
class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while (st == null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt(){ return Integer.parseInt(next()); }
    long nextLong(){ return Long.parseLong(next()); }
    double nextDouble(){ return Double.parseDouble(next()); }
    String nextLine(){
        String str = "";
        try{ str = br.readLine(); }
        catch (IOException e){ e.printStackTrace(); }
        return str;
    }
    int[] nextIntArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        int[] arr = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) arr[i] = Integer.parseInt(strNums[i]);
        return arr;
    }
    long[] nextLongArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        long[] arr = new long[strNums.length];
        for (int i = 0; i < strNums.length; i++) arr[i] = Long.parseLong(strNums[i]);
        return arr;
    }
    char[] nextCharArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        char[] arr = new char[strNums.length];
        for (int i = 0; i < strNums.length; i++) arr[i] = strNums[i].charAt(0);
        return arr;
    }
    char[] StringtoChar() {
        String line = nextLine();
        return line.toCharArray();
    }
}

class FastWriter {
    private final PrintWriter writer;
    public FastWriter() {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
    }
    public void print(Object object) { writer.print(object); }
    public void println(Object object) { writer.println(object); }
    public void flush() { writer.flush(); }
}
