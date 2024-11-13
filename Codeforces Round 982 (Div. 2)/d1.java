import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d1 {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int m = fr.nextInt();
        int a[]  = fr.nextIntArray();
        int b[] = fr.nextIntArray();
        // if(a[0]>b[0]){
        //     fw.println(-1);
        //     return;
        // }
        long pre[] = new long[n];
        pre[0] = a[0];
        for(int i=1;i<n;i++) pre[i] = pre[i-1] + a[i];
        long dp[][] = new long[n+1][m+1];
        for(long i[] : dp) Arrays.fill(i, -1);

        long ans = rec(dp, pre, a, b, 0, 0);
        if(ans == Integer.MAX_VALUE) ans = -1;
        fw.println(ans);
    }
    public static long rec(long dp[][], long[] pre, int[] a, int[] b, int i, int j){
        int n = a.length;
        int m = b.length;

        long ans = Integer.MAX_VALUE;
        if(i>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=j;k<m && b[k]>=a[i];k++){
            int ind = bs(pre, pre[i] + b[k] - a[i]);
            //if(ind==n-1) ans = Math.min(ans, m-k-1);
            ans =  Math.min(ans, m-k-1 + rec(dp, pre, a, b, ind+1, k));
            //System.out.println(i+" "+k+" "+ans);
        }
        return dp[i][j] = ans;
    }
    public static int bs(long[] pre, long val){
        int low = 0;
        int high = pre.length;
        int ans = 0;
        while(low < high){
            int mid = low + (high - low)/2;
            if(pre[mid]<=val){
                ans = mid;
                low = mid + 1;
            }
            else high = mid;
        }
        return ans;
    }
    public static int bs(long[] sum, long val, int high){
        int low = 0;
        int ans = high;
        while(low<high){
            int mid = low + (high-low)/2;
            if(sum[mid]<val){
                ans = mid;
                high = mid;
            }
            else low = mid+1;
        }
        return ans;
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
