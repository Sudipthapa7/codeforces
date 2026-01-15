import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class g{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int ans = 0, Cmin = 0;
    static int MAX = (int)1e6;
    static class SegTree{
        int n, arr[], a[];
        public SegTree(int a[]){
            n = a.length;
            arr = new int[4*n];
            this.a = a;
            build(1, 0, n-1);
        }
        public void build(int ind, int low, int high){
            if(low == high){ 
                arr[ind] = a[low]; 
                return;
            }
            int mid = low + (high - low) / 2;
            build(2*ind, low, mid);
            build(2*ind+1, mid+1, high);
            arr[ind]  = Math.min(arr[2*ind] , arr[2*ind+1]);
        }
        public void update(int ind, int low , int high, int l, int val){
            if(l < low || l > high) return;
            if(low == high){
                arr[ind] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            update(2*ind, low, mid, l, val);
            update(2*ind+1, mid+1, high, l, val);
            arr[ind] = Math.min(arr[2*ind], arr[2*ind+1]);
        }
        public int find(int ind, int low, int high, int l, int r){
            // fw.println("seg " + low + " " + high + " " + l + " " + r);
            if(l > high || r < low) return MAX;
            if(l <= low && r >= high) return arr[ind];
            int mid = low + (high - low) / 2;
            return Math.min(find(2*ind, low, mid, l, r), find(2*ind+1, mid+1, high, l, r));
        }
        public void findInter(int ind, int low, int high, int l, int r){
            if(l > high && r < low) return;
            if(ans != MAX) return;
            if(l <= low && r >= high && Math.min(Cmin, arr[ind]) < high - l){
                Cmin = Math.min(Cmin, arr[ind]);
                return;
            }
            if(low == high){
                ans = l;
                return;
            }
            int mid = low + (high - low) / 2;
            findInter(2*ind, low, mid, l, r);
            findInter(2*ind+1, mid+1, high, l, r);
        }
    }
    public static void solve(){
        int n = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();

        SegTree seg = new SegTree(a);
        // for(int i : seg.arr){
        //     fw.print(i + " ");
        // }
        // fw.println("");
        // fw.println("01 " + seg.find(1, 0, n-1, 0, 1));
        while (q-- > 0){
            int id = fr.nextInt();
            if(id==1){
                int ind = fr.nextInt()-1;
                int x = fr.nextInt();
                seg.update(1, 0, n-1, ind, x);
                continue;
            }
            int l = fr.nextInt() - 1;
            int r = fr.nextInt() - 1;
            // int min = seg.find(1, 0, n-1, l, r);
            // if(min > r - l){
            //     fw.println(0);
            //     return;
            // }
            ans = -1;
            int low = l, high = r+1;
            while(low < high){
                int mid = low + (high - low) / 2;
                // fw.println(mid+" " + seg.find(1, 0, n, l, mid));
                if(seg.find(1, 0, n-1, l, mid) <= mid - l){
                    ans = mid;
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            if(ans != -1 && seg.find(1,0, n-1, l, ans) == ans - l){
                fw.println(1);
            }
            else fw.println(0);
        }

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
