import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class g2 {
    static class Pair{
        int fir, sec;
        public Pair(int fir, int sec){
            this.fir = fir;
            this.sec = sec;
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static int find(ArrayList<Integer> list, int val){
        int low  = 0, high = list.size();
        int ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid)<=val){
                ans = mid;
                low = mid+1;
            }
            else high = mid;
        }
        return ans;
    }
    public static int find2(ArrayList<Integer> list, int val){
        int low  = 0, high = list.size();
        int ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid)>=val){
                ans = mid;
                high  = mid;
            }
            else low = mid+1;
        }
        return ans;
    }
    static long[] t;
    static long[] laz;
    static long[] cnt;
    static long build(int a[], int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
            return cnt[v] = 1;
        } else {
            int tm = (tl + tr) / 2;
            long c1 = build(a, v*2, tl, tm);
            long c2 = build(a, v*2+1, tm+1, tr);
            t[v] = t[v*2] + t[v*2+1];
            return cnt[v] = c1 + c2;
        }
    }
    static long sum(int v, int tl, int tr, int l, int r,long val) {
        if (l > r) 
            return 0;
        if(laz[v]!=-1) {
            val = Math.min(val, laz[v]);
        }
        if(val!=Integer.MAX_VALUE) laz[v] = val;
        if (l == tl && r == tr) {
            t[v] = Math.min(t[v], 1L*val*cnt[v]);
            //if(v==5) System.out.println(t[v]);
            return t[v];
        }
        int tm = (tl + tr) / 2;
        return sum(v*2, tl, tm, l, Math.min(r, tm), val)
               + sum(v*2+1, tm+1, tr, Math.max(l, tm+1), r, val);
    }
    static void update(int v, int tl, int tr, int l, int r, int val) {
        if (l==tl && r==tr){
            laz[v] = val;
            t[v] = 1L*cnt[v]*laz[v];
            return;
        } else {
            int tm = (tl + tr) / 2;
            if (l <= tm)
                update(v*2, tl, tm, l, Math.min(r, tm), val);
            if(r>tm)
                update(v*2+1, tm+1, tr, Math.max(l, tm+1), r, val);
            t[v] = t[v*2] + t[v*2+1];
        }
    }
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = new int[n];
        for(int i=0;i<n;i++) b[i] = a[i]-i;
        int ans[] = new int[n-k+1];
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
             map.put(b[i], map.getOrDefault(b[i], 0)+1);
             if(map.get(b[i])==1) list.add(0,1);
             else{
                int ind = find(list, map.get(b[i])-1);
                list.set(ind, list.get(ind)+1);
             }
        }
        ans[0] = k-list.get(list.size()-1);
        //System.out.println(list);
        for(int i=k;i<n;i++){
            map.put(b[i], map.getOrDefault(b[i], 0)+1);
             if(map.get(b[i])==1) list.add(0,1);
             else{
                int ind = find(list, map.get(b[i])-1);
                list.set(ind, list.get(ind)+1);
             }
             int j = i-k;
             if(map.get(b[j])==1){
                map.remove(b[j]);
                list.remove(0);
                ans[i-k+1] = k-list.get(list.size()-1);
                continue;
             }
             map.put(b[j], map.get(b[j])-1);
             int ind  = find2(list, map.get(b[j])+1);
             list.set(ind, list.get(ind)-1);
             ans[i-k+1] = k-list.get(list.size()-1);
             //System.out.println(list);
        }
        int len = ans.length;
        t = new long[4*n];
        laz = new long[4*n];
        cnt = new long[4*n];
        Arrays.fill(laz, -1);
        build(ans, 1, 0, len-1);
        long ret[] = new long[q];
        int arr[][] = new int[q][3];
        for(int i=0;i<q;i++){
            int l = fr.nextInt();
            int r = fr.nextInt();
            l--; r--;
            arr[i][0] = i;
            arr[i][1] = l;
            arr[i][2] = r;
        }
        Arrays.sort(arr, (x,y)->(x[1]-y[1]));
        int x = len-1;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, len));
        for(int i=q-1;i>=0;i--){
            while(x>=arr[i][1]){
                while(!st.isEmpty() && st.peek().fir>ans[x]){
                    st.pop();
                }
                update(1, 0, len-1, x, st.peek().sec-1, ans[x]);
                //System.out.println(x+" "+(st.peek().sec-1));
                st.push(new Pair(ans[x], x));
                x--;
            }
            //if(i==0) laz[5]= 2;
            ret[arr[i][0]] = sum(1,0, len-1, arr[i][1], arr[i][2]-k+1, Integer.MAX_VALUE);
            //System.out.println(arr[i][0] +" "+ ret[arr[i][0]]);
        }
        // for(int i=0;i<4*len;i++) System.out.print(laz[i]+" ");
        // System.out.println();
        // for(int i=0;i<4*len;i++) System.out.print(t[i]+" ");
        // System.out.println();
        for(int i=0;i<q;i++) fw.println(ret[i]);
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
