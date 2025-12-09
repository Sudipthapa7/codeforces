import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class e{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int p[] = new int[n+1];
        int q[] = new int[n+1];
        for(int i=1;i<=n;i++){
            p[i] = fr.nextInt();
            q[p[i]] = i;
        }
        if(n%2==1){
            int mid = (n+1) / 2;
            while(q[mid] != mid){
                fw.println("? " + mid + " " + q[mid]);
                fw.flush();
                int x = fr.nextInt(); int y = fr.nextInt();

                int temp = p[x];
                p[x] = p[y];
                p[y] = temp;
                q[p[x]] = x; q[p[y]] = y;
            }
        }
        for(int i=1;i<=n/2;i++){
            if(q[i] + q[n+1-i] != n+1){
                fw.println("? " + q[i] + " " + (n+1-q[n+1-i]));
                fw.flush();
                int x = fr.nextInt();
                int y = fr.nextInt();
                int temp = p[x];
                p[x] = p[y];
                p[y] = temp;
                q[p[x]] = x; q[p[y]] = y;
            }
        }
        // for(int i : p) fw.print(i+ " ");
        // fw.println("");
        for(int i=1;i<=n/2;i++){
            while(q[i] != i || q[n+1-i] != n+1-i){
                if(q[i] != i) fw.println("? " + i + " " + q[i]);
                else fw.println("? " + (n+1-i) + " " + q[n+1-i]);
                fw.flush();
                int x = fr.nextInt();
                int y = fr.nextInt();
                int temp = p[x];
                p[x] = p[y];
                p[y] = temp;
                q[p[x]] = x; q[p[y]] = y;
            }
        }
        fw.println("!");
        fw.flush();
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
