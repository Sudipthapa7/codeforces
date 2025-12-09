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
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();

        int cnt = 0;
        for(int i=0;i<31;i++){
            if((1<<i & n) != 0) cnt++;
        }
        if(k > 31){
            fw.println(k + cnt - 1);
            return;
        }
        int dp[][][] = new int[32][k+1][2];
        for(int i[][] : dp) for(int j[] : i)Arrays.fill(j, -1);
        int ans = rec(dp, n, k, 0, 0);
        fw.println(cnt + k - ans);
    }
    public static int rec(int[][][] dp, int n, int k, int i, int c){
        int ans = 1000;
        if(i > 30) return c;
        if(dp[i][k][c] != -1) return dp[i][k][c];
        if(k==0){
            int val = 0; int carry = 0;
            if((1<<i & n) != 0) val = 1;;
            if(c==1 && val==1){
                val = 0;
                carry = 1;
            }
            else if(c==1) val = 1;
            return  dp[i][k][c] = val + rec(dp,n, k, i+1, carry);
        }
        if((1<<i & n) != 0){
            if(c==1){
                // ans = Math.min(ans, 1 + rec(n, k-1, i+1, 1));
                ans = Math.min(ans, rec(dp, n, k, i+1, 1));
            }
            else{
                ans = Math.min(ans, 1 + rec(dp, n, k, i+1, 0));
                ans = Math.min(ans, rec(dp, n, k-1, i+1, 1));
            }
        }
        else{
            if(c==1){
                ans = Math.min(ans, 1 + rec(dp, n, k, i+1, 0));
                ans = Math.min(ans, rec(dp, n, k-1, i+1, 1));
            }
            else{
                ans = Math.min(ans, rec(dp, n, k, i+1, 0));
                ans = Math.min(ans, 1 + rec(dp, n, k-1, i+1, 0));
            }
        }
        return dp[i][k][c] = ans;
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
