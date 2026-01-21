import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class f{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int ans;
    public static void solve(){
        int n = fr.nextInt();
        n = 1<<n;
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = new int[n*4];
        build(b, a, 1, 0, n-1);
        for(int i=0;i<q;i++){
            int index = fr.nextInt() - 1;
            int val = fr.nextInt();
            ans = 0;
            find(b, 1, 0, n-1, index, val);
            fw.println(ans);
        }
    }
    public static int find(int b[], int ind, int i, int j, int index, int val){
        if(i==j) return val;
        int mid = i + (j-i) / 2;
        // int x = b[2*ind];
        // int y = b[2*ind+1];
        if(index <= mid){
            int x = find(b, 2*ind, i, mid, index, val);
            int y = b[2*ind+1];
            if(x < y) ans += (mid-i+1);
            return x ^ y;
        }
        int x = b[2*ind];
        int y = find(b, 2*ind+1, mid+1, j, index, val);
        if(y <= x) ans += (mid-i+1);
        return x ^ y;
    }
    public static void build(int b[], int a[], int ind, int i, int j){
        if(i==j){
            b[ind] = a[i];
            return;
        }
        int mid = i + (j - i) / 2;
        build(b, a, 2*ind, i, mid);
        build(b, a, 2*ind+1, mid+1, j);
        b[ind] = b[2*ind] ^ b[2*ind+1];
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
