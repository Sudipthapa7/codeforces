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
        String a = fr.next();
        String b = fr.next();

        int dp[][] = new int[n+1][3];
        for(int i=2;i<=n;i++){
            if(i%3==1) continue;
            if(i%3==0) {
                dp[i][0] = Math.max(dp[i][0], dp[i-3][0] + u(a,b,i-1) + w(a,b,i-1));
                dp[i][0] = Math.max(dp[i][0] , dp[i-1][1] + y(a,b,i-1));
                dp[i][0] = Math.max(dp[i][0] , dp[i-1][2] + z(a, b, i-1));
                continue;
            }

            dp[i][1] = Math.max(dp[i][1] , dp[i-2][0] + v(a,b, i-1));
            if(i>3) dp[i][1] = Math.max(dp[i][1] , dp[i-3][1] + u(a, b, i-1) + w(a,b, i-2));

            dp[i][2] = Math.max(dp[i][2] , dp[i-2][0] + x(a,b, i-1));
            if(i>3) dp[i][2] = Math.max(dp[i][2] , dp[i-3][2] + u(a, b, i-2) + w(a,b, i-1));
            //ans = Math.max(ans, Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
        }
        // for(int i=0;i<=n;i++){
        //     System.out.println(dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
        // }
        fw.println(dp[n][0]);
    }
    public static int u(String a, String b, int i){
        int cnt = 0;
        if(a.charAt(i)=='A') cnt++;
        if(a.charAt(i-1)=='A') cnt++;
        if(a.charAt(i-2)=='A') cnt++;
        return cnt>=2?1:0;
    }
    public static int v(String a, String b, int i){
        int cnt = 0;
        if(a.charAt(i-1)=='A') cnt++;
        if(b.charAt(i-1)=='A') cnt++;
        if(a.charAt(i)=='A') cnt++;
        return cnt>=2?1:0;
    }
    public static int w(String a, String b, int i){
        int cnt = 0;
        if(b.charAt(i)=='A') cnt++;
        if(b.charAt(i-1)=='A') cnt++;
        if(b.charAt(i-2)=='A') cnt++;
        return cnt>=2?1:0;
    }
    public static int x(String a, String b, int i){
        int cnt = 0;
        if(a.charAt(i-1)=='A') cnt++;
        if(b.charAt(i-1)=='A') cnt++;
        if(b.charAt(i)=='A') cnt++;
        return cnt>=2?1:0;
    }
    public static int y(String a, String b, int i){
        int cnt = 0;
        if(a.charAt(i)=='A') cnt++;
        if(b.charAt(i-1)=='A') cnt++;
        if(b.charAt(i)=='A') cnt++;
        return cnt>=2?1:0;
    }
    public static int z(String a, String b, int i){
        int cnt = 0;
        if(a.charAt(i)=='A') cnt++;
        if(a.charAt(i-1)=='A') cnt++;
        if(b.charAt(i)=='A') cnt++;
        return cnt>=2?1:0;
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
