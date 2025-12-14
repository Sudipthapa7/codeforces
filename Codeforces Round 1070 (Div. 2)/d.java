import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int mod = 998244353;
    public static void solve(){
        int n = fr.nextInt();
        int m = fr.nextInt();
        long a[] = fr.nextLongArray();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u = fr.nextInt();
            int v = fr.nextInt();
            g.get(v-1).add(u-1);
        }
        ArrayList<Map<Long, Long>> prev = new ArrayList<>();
        for(int i=0;i<n;i++) prev.add(new HashMap<>());

        long b[][] = new long[n][2];
        for(int i=0;i<n;i++){
            b[i][0] = a[i]; b[i][1] = i;
        }
        Arrays.sort(b, (x,y)->Long.compare(x[0] , y[0]));
        long ans = 0;
        for(int i=0;i<n;i++){
            int u = (int)(b[i][1]);
            long val = b[i][0];
            for(int v : g.get(u)){
                long req = val - a[v];
                long cur = (prev.get(v).getOrDefault(req, 0L) + 1) %  mod;
                ans = (ans + cur) % mod;
                cur = (cur + prev.get(u).getOrDefault(a[v], 0L)) % mod;
                prev.get(u).put(a[v], cur);
            }
        }
        fw.println(ans);
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
