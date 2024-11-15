import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static class Pair{
        int fir;
        long sec;
        public Pair(int fir, long sec){
            this.fir = fir;
            this.sec = sec;
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int mod  = (int)1e9+7;
    public static int get(int a){
        int ans = 0;
        while(a%2==0){
            ans++;
            a/=2;
        }
        return ans;
    }
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();
        Stack<Pair> st = new Stack<>();
        //ArrayList<ArrayList<Integer>> cnt = new ArrayList<>();
        long ans = 0;
        for(int i=0;i<n;i++){
            long x = 1<<get(a[i]);
            long y = a[i]/x;
            long temp = a[i];
            boolean ok = false;
            while(!st.isEmpty() && (st.peek().fir<=temp || ok)){
                Pair p = st.pop();
                long val = ((p.fir * p.sec)%mod - p.fir + mod)%mod;
                ans  = (ans - val + mod)%mod;
                x = (x * p.sec)%mod;
                if(temp * p.sec>=mod) ok= true;
                temp = (temp * p.sec)%mod;
            }
            if(x>1)st.push(new Pair((int)y, x));
            ans = (ans + y * x)%mod;
            fw.print(ans+" ");
        }
        fw.println("");

    }
    public static int bs(ArrayList<Integer> list, int val){
        int low = 0;
        int high = list.size();
        while(low<high){
            int mid = low + (high-low)/2;
            if(list.get(mid)>=val) high = mid;
            else low = mid+1;
        }
        return high;
    }
    public static int bs2(ArrayList<ArrayList<Integer>> list, int val){
        int low = 0;
        int high = list.size();
        while(low<high){
            int mid = low + (high-low)/2;
            if(list.get(mid).get(0)>=val) high = mid;
            else low = mid+1;
        }
        return high;
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