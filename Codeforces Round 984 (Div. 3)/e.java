import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class e {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();
        int q = fr.nextInt();

        int a[][] = new int[n][k];
        for(int i=0;i<n;i++) for(int j=0;j<k;j++) a[i][j] = fr.nextInt();

        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                a[i][j] |= a[i-1][j];
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<k;j++)System.out.print(a[i][j]+" ");
        //     System.out.println();
        // }
        for(int ind=0;ind<q;ind++){
            int m = fr.nextInt();
            int max = n, min = 0;
            for(int z=0;z<m;z++){
                int j = fr.nextInt()-1;
                char c = fr.next().charAt(0);
                int val = fr.nextInt();
                if(c=='>'){
                    int cur = bs1(a, j, val);
                    min = Math.max(min, cur);
                    // System.out.println(cur);
                }
                else{
                    int cur = bs2(a, j, val);
                    max = Math.min(max, cur);
                    // System.out.println(cur);
                }
            }
            if(min>max || min>=n || max<0) fw.println(-1);
            else fw.println(min+1);
        }
    }
    public static int bs1(int a[][], int j, int val){
        int n = a.length;
        int low  = 0;
        int high = n;
        int ans = n;
        while(low<high){
            int mid  = low + (high - low)/2;
            if(a[mid][j]>val){
                ans = mid;
                high = mid;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public static int bs2(int a[][], int j, int val){
        int n = a.length;
        int low  = 0;
        int high = n;
        int ans = -1;
        while(low<high){
            int mid  = low + (high - low)/2;
            if(a[mid][j]<val){
                ans = mid;
                low = mid+1;
            }
            else high = mid;
        }
        return ans;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int t = 1;
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
