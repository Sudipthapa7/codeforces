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
        int m = fr.nextInt();
        int k = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = fr.nextIntArray();
        String s = fr.next();
        Arrays.sort(b);
        PriorityQueue<int[]> l = new PriorityQueue<>((x,y)->x[1] - y[1]);
        PriorityQueue<int[]> r = new PriorityQueue<>((x,y)->x[1] - y[1]);
        for(int i=0;i<n;i++){
            int left = bsl(b, a[i]);
            int right = bsr(b, a[i]);
            int MAX = 10000010;
            int val = left==-1?MAX : a[i] - b[left];
            l.add(new int[]{i, val});
            val = right == -1 ? MAX : b[right] - a[i];
            r.add(new int[]{i, val});
        }
        boolean vis[] = new boolean[n];
        int shift = 0;
        int ans = n;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='L') shift--;
            else shift++;
            while(!l.isEmpty() && 0L + l.peek()[1] + shift <= 0){
                int cur[] = l.poll();
                if(!vis[cur[0]]) ans--;
                vis[cur[0]] = true;
            }
            while(!r.isEmpty() && 0L + r.peek()[1] - shift <= 0){
                int cur[] = r.poll();
                if(!vis[cur[0]]) ans--;
                vis[cur[0]] = true;
            }
            fw.print(ans + " ");
        }
        fw.println("");
    }
    public static int bsl(int a[], int val){
        int low = 0, high = a.length, ans = -1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(a[mid] <= val){
                ans = mid;
                low = mid + 1;
            }
            else high = mid;
        }
        return ans;
    }
    public static int bsr(int a[], int val){
        int low = 0, high = a.length, ans = -1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(a[mid] < val){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid;
            }
        }
        return ans;
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
