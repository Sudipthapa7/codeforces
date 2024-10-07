import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static long ans;
    public static void solve(){
        int n = fr.nextInt();
        long[] a = fr.nextLongArray();
        long low = 0;
        long high = (long)1e12 + 200;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(long i : a){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        while(low < high){
            long mid = low + (high - low)/2;
            if(poss(a, mid)){
                min = mid;
                low = mid+1;
            }
            else high  = mid;
        }
        low = 0; high = (long)1e12+200;
        while(low < high){
            long mid = low + (high - low)/2;
            if(poss2(a, mid)){
                max = mid;
                high = mid;
            }
            else low  = mid+1;
        }
        //System.out.println(min + " " + max);
        fw.println(max - min);
        //System.out.println(poss(a, 5));
    }
    public static boolean poss(long[] a, long val){
        int n = a.length;
        long cur = a[n-1], nxt = a[n-1];
        for(int i=n-1;i>0;i--){
            cur = nxt;
            nxt = a[i-1];
            if(cur<val){
                nxt -= val-cur;
                cur  = val;
            }
            //System.out.println(nxt);
        }
        return nxt >= val;
    }
    public static boolean poss2(long[] a, long val){
        int n = a.length;
        long cur = a[0], nxt = a[0];
        for(int i=0;i<n-1;i++){
            cur = nxt;
            nxt = a[i+1];
            if(cur>val){
                nxt += cur-val;
                cur  = val;
            }
        }
        return nxt <= val;
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
