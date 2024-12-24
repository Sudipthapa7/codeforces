import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class c {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();

        int dp[][] = new int[n+1][2];
        dp[1][0] = 1;
        int val = 0;
        int ans = 1;
        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][0];
            if(a[i-1]>dp[i-1][0]) dp[i][0]++;
            else if(a[i-1]<dp[i-1][0]) dp[i][0]--;
            
            dp[i][1] = dp[i-1][1];
            if(a[i-1]>dp[i-1][1]) dp[i][1]++;
            else if(a[i-1]<dp[i-1][1]) dp[i][1]--;
            //val = Math.max(val, dp[i][0]);
            if(a[i-1]>=val){
                dp[i][1] = Math.max(dp[i][1], val);
            }
            else dp[i][1] = Math.max(dp[i][1], a[i-1]);
            dp[i][1] = Math.max(dp[i][1], ans);
            if(i!=n) ans = Math.max(ans, dp[i][0]);
            val = Math.max(val, dp[i][0]);
            dp[i][1] = Math.min(dp[i][1], i-1);
        }
        // for(int i=0;i<=n;i++){
        //     System.out.println(dp[i][0] + " " + dp[i][1]);
        // }
        ans = Math.max(dp[n][1], ans);
        ans = Math.min(ans, n-1);
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
