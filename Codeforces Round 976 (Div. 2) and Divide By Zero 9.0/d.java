import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static class UnionFind{
        int size[];
        int parent[];
    
        UnionFind(int n){
            size = new int[n+1];
            parent = new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i] = i;
            }
        }
         int findParent(int x){
            if(parent[x]==x) return x;
            return parent[x] = findParent(parent[x]);
        }
        void union(int x, int y){
            x = findParent(x); y = findParent(y);
            if(size[x]>size[y]){
                size[x]+=size[y];
                parent[y] = x;
            }
            else{
                size[y]+=size[x];
                parent[x] = y;
            }
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int m = fr.nextInt();

        int a[][]  = new int[m][3];
        for(int i=0;i<m;i++){
            a[i][0] = fr.nextInt()-1;
            a[i][1] = fr.nextInt();
            a[i][2] = fr.nextInt();
        }
        Arrays.sort(a, (x,y) -> x[0] - y[0]);
        // for(int i=0;i<m;i++){
        //     System.out.println(a[i][0]+" " + a[i][1] + " " + a[i][2]);
        // }
        int dp[][] = new int[n][11];
        UnionFind uf = new UnionFind(n);

        int ind = 0;
        for(int i=0;i<n;i++){
            while(ind < m && a[ind][0]==i){
                dp[i][a[ind][1]] = Math.max(dp[i][a[ind][1]], a[ind][2]);
                ind++;
            }
            for(int j=0;j<11;j++){
                if(dp[i][j]>0){
                    dp[i+j][j] = dp[i][j] - 1;
                    uf.union(i, i+j);
                    //System.out.println(i + " " + (i+j));
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(uf.parent[i]==i) ans++;
        }
        fw.println(ans);
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int t = fr.nextInt();
        //System.out.println(solve());
        //System.out.println(solve()?"YES":"NO");
        while(t-->0){
            solve();
            //System.out.println(solve());
            //System.out.println(solve()?"YES":"NO");
        }
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
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    String nextLine(){
        String str = "";
        try{
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
    int[] nextIntArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        int[] arr = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            arr[i] = Integer.parseInt(strNums[i]);
        }
        return arr;
    }
    long[] nextLongArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        long[] arr = new long[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            arr[i] = Long.parseLong(strNums[i]);
        }
        return arr;
    }
    char[] nextCharArray() {
        String line = nextLine();
        String[] strNums = line.split("\\s+");
        char[] arr = new char[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            arr[i] = strNums[i].charAt(0);
        }
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

    public void print(Object object) {
        writer.print(object);
    }

    public void println(Object object) {
        writer.println(object);
    }

    public void flush() {
        writer.flush();
    }
}
