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
        int m = fr.nextInt();
        int v = fr.nextInt();

        int a[] = fr.nextIntArray();
        long pre[] = new long[n+1];
        for(int i=1;i<=n;i++) pre[i] = pre[i-1] + a[i-1];
        int fir[] = new int[m+1];
        int last[] = new int[m+1];
        long ans = 0;
        int cnt = 1;
        long sum = 0;
        boolean ok  = false;
        for(int i=0;i<n;i++){
            sum += a[i];
            fir[cnt] = i;
            if(sum>=v){
                cnt++;
                sum = 0;
            }
            if(cnt>m){
                ok = true;
                ans = Math.max(ans, pre[n] - pre[i+1]);
                break;
            }
        }
        cnt = 1;
        sum = 0;
        for(int i=n-1;i>=0;i--){
            sum += a[i];
            last[cnt] = i;
            if(sum>=v){
                cnt++;
                sum = 0;
            }
            if(cnt>m){
                ok = true;
                ans = Math.max(ans, pre[i]);
                break;
            }
        }
        if(!ok){
            fw.println(-1);
            return;
        }
        // System.out.println(ans);
        //for(int i=0;i<=m;i++)System.out.println(fir[i] + " " + last[i]);
        for(int i=1;i<m;i++){
            int rem = m - i;
            if(last[rem]>fir[i]){
                long val = pre[last[rem]] - pre[fir[i]+1];
                ans = Math.max(ans, val);
            }
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
