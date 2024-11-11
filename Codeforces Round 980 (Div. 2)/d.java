import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static class Pair{
        int fir; long sec;
        public Pair(int fir, long sec){
            this.fir = fir;
            this.sec = sec;
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = fr.nextIntArray();
        // boolean c[] = new boolean[n];
        //simple recursion
        //int ans = find(a, b, 0, c);
        long ans = a[0];
        long pre[] = new long[n];
        pre[0]  = a[0];
        b[0]--;
        for(int i=1;i<n;i++){
            b[i]--;
            pre[i] = pre[i-1] + a[i];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Long.compare(x.sec, y.sec));
        pq.add(new Pair(b[0], a[0]));
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek().fir<i) pq.poll();
            if(pq.isEmpty()) break;
            ans = Math.max(ans, pre[i] - pq.peek().sec);
            pq.add(new Pair(b[i], pq.peek().sec + a[i]));
        }
        fw.println(ans);
    }
    public static int find(int a[], int b[], int ind, boolean c[]){
        while(ind>=0 && c[ind]) ind--;
        if(ind==-1) return 0;
        c[ind] = true;
        int ans = Math.max(a[ind] + find(a, b, ind-1, c), find(a, b, b[ind]-1, c));
        c[ind] = false;
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
