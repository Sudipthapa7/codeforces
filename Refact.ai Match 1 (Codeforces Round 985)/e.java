import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class e {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void seiveofErathosthenis(int N ){
        boolean[] a = new boolean[N];
        Arrays.fill(a, true);
        a[1] = false;
        for(int i=2;i<N;i++){
            if(a[i]){
                int b = i;
                int j = 2;
                while(b*j<N){
                    a[b*j]=false;
                    j++;
                }
            }
        }
        for(int i=2;i<N;i++){
            if(a[i]) list.add(i);
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int b[];
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();
        Arrays.sort(a);
        int ans = Integer.MAX_VALUE;
        boolean ok = false;
        int req = 0;
        for(int i=0;i<n;i++){
            int val = a[i];
            if(a[i]%2==1) val = b[a[i]];
            if(ok && val<req){
                fw.println(-1);
                return;
            }
            //System.out.println(val);
            if(val==0){
                if(a[i]!=a[0]){
                    fw.println(-1);
                    return;
                }
                ans = Math.min(ans, a[i]);
                ok= true;
                req = a[i] * 2;
            }
            else ans = Math.min(ans, val);
        }
        fw.println(ans);
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int t = fr.nextInt();
        seiveofErathosthenis(400400);
        b = new int[400001];
        Arrays.fill(b, 0);
        for(int i : list){
            if(i>400000) break;
            int j  = 2;
            while((i * j )<= 400000){
                if(b[i * j]==0) b[i*j] = i * j - i;
                j++;
            }
        }
        //System.out.println(list.size());
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
