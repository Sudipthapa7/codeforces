import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class f {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        long pre[] = new long[n];
        pre[0] = a[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]+a[i];
        }
        long sum = pre[n-1];
        for(int i=0;i<q;i++){
            long l = fr.nextLong();
            long r = fr.nextLong();
            l--; r--;
            long ans = 0;
            long x = l/n;
            long x1 = l%n;
            long val1 = 0;
            //System.out.println(x+" "+x1);
            if(x+x1<n) val1 = pre[n-1]-(x+x1>0?pre[(int)(x+x1-1)]:0);
            if(x>0) val1+=pre[(int)(x-1)] - (x+x1>n?pre[(int)(x+x1)%n-1]:0);
            //System.out.println(val1);
            long y = r/n;
            long y1 = r%n;
            int ind = Math.min(n-1, (int)(y+y1));
            if(x==y){
                if(x+x1<n) ans = pre[ind]-((x+x1>0)?pre[(int)((x+x1)%n-1)]:0);
                if(y+y1>n-1) ans+=(pre[(int)(y+y1-n)] - (x+x1>n?pre[(int)(x+x1)%n-1]:0));
                fw.println(ans);
                continue;
            }
            //System.out.println(y+" "+y1+" "+ind);
            long val2 = pre[ind]-(y>0?pre[(int)(y-1)]:0);
            //System.out.println(val2);
            if(y+y1>n-1) val2+=(pre[(int)(y+y1-n)]);
            ans = val1 + val2 + (sum*(y-x-1));
            //System.out.println(val1+" "+val2);
            fw.println(ans);
        }
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
