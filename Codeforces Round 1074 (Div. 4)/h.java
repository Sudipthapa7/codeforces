import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class h{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();
        int a[] = fr.nextIntArray();
        long pre[] = new long[n];
        pre[0] = a[0];
        
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + a[i];
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int last = bs(pre, a[i], i, a);
            // fw.println(last);
            ArrayList<Integer> list = new ArrayList<>();
            int pos = -1;
            while(true){
                long val = prefix(pre, 0, pos, i, a) + a[i];
                int bad = bs(pre, 2*val+1 - a[i], i, a);
                if(bad >= n-1) break;
                // fw.println("bad " + bad);
                val = prefix(pre, 0, bad-1, i, a) + a[i];
                // fw.println("x " + prefix(pre, bad, bad, i, a) + " " + val);
                if(prefix(pre, bad,bad, i, a)  > val){
                    list.add(bad+1);
                }
                pos = bad;
            }
            // fw.println(list);
            if(k==0){
                if(list.size()==0) ans[i] += last + 1;
            }
            else if(list.size() > k) ans[i] += n - list.get(list.size()-k);
            else if(list.size() < k) ans[i] += n;
            else ans[i] += Math.min(n, last + 1 + n - list.get(0));
           fw.print(ans[i] + " ");
        }
        fw.println("");
        
    }

    public static int bs(long pre[], long val, int i, int a[]){
        int low = 0;
        int high = pre.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid==0 || prefix(pre, 0, mid-1, i, a) < val){
                low = mid + 1;
            }
            else high = mid;
        }
        return high - 1;
    }
    public static long prefix(long pre[], int x, int y, int i, int a[]){
        if(x < 0 || y < 0 || y < x) return 0;
        if(i > y) return pre[y] - (x == 0 ? 0 : pre[x-1]);
        if(i < x){
            x++; y++;
            return pre[y] - (x==0?0:pre[x-1]);
        }
        y++;
        return pre[y] - (x==0?0:pre[x-1]) - a[i];
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
