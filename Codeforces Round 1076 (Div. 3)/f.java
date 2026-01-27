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
    public static void solve(){
        int n = fr.nextInt();
        int ax = fr.nextInt();
        int ay = fr.nextInt();
        int bx = fr.nextInt();
        int by = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = fr.nextIntArray();
        int c[][] = new int[n+1][2];
        for(int i=0;i<n;i++){
            c[i][0] = a[i];
            c[i][1] = b[i];
        }
        c[n][0] = bx;
        c[n][1] = by;
        long val1 = 0;
        long val2 = 0;
        Arrays.sort(c, (x,y)-> x[0] - y[0]);
        int i = 0;
        int ay2 = ay;
        while(i <= n){
            int cur = c[i][0];
            int min = c[i][1], max = c[i][1];
            while(i<=n && c[i][0] == cur){
                min = Math.min(min, c[i][1]);
                max = Math.max(max, c[i][1]);
                i++;
            }
            long must = cur - ax;
            ax = cur;
            long lef = 0, rig = 0;
            if(ay <= min){
                lef = 0L + max - ay + max - min;
                rig = max - ay;
            }
            else if(ay <= max){
                lef = 2L * (max - ay) + (ay - min);
                rig = 2L * (ay - min) + (max - ay);
            }
            else{
                lef = 0L + ay - min;
                rig = 0L + ay - min + max - min;
            }
            long temp1 = val1 + must + lef;
            long temp2 = val1 + must + rig;

            if(ay2 <= min){
                lef = 0L + max - ay2 + max - min;
                rig = max - ay2;
            }
            else if(ay2 <= max){
                lef = 2L * (max - ay2) + (ay2 - min);
                rig = 2L * (ay2 - min) + (max - ay2);
            }
            else{
                lef = 0L + ay2 - min;
                rig = 0L + ay2 - min + max - min;
            }
            val1 = Math.min(temp1, val2 + must + lef);
            val2 = Math.min(temp2, val2 + must + rig);
            ay = min;
            ay2 = max;
        }
        fw.println(Math.min(val1, val2));
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
