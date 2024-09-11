import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[][] = new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0] = fr.nextInt();
            a[i][1] = fr.nextInt();
        }
        Arrays.sort(a, (x,y)->(x[0]-y[0]));
        long ans = 0;
        for(int i=0;i<n;i++){
            if(i>0 && a[i][0]==a[i-1][0]) ans += (n-2);
            boolean left = false;
            boolean right = false;
            int cur = a[i][0];
            if(a[i][1]==0){
                int ind = i;
                while(ind>=0 && a[ind][0]>=cur-1){
                    if(a[ind][0]==cur-1 && a[ind][1]==1) left = true;
                    ind--;
                }
                ind = i;
                while(ind<n && a[ind][0]<=cur+1){
                    if(a[ind][0]==cur+1 && a[ind][1]==1) right = true;
                    ind++;
                }
            }
            else{
                int ind = i;
                while(ind>=0 && a[ind][0]>=cur-1){
                    if(a[ind][0]==cur-1 && a[ind][1]==0) left = true;
                    ind--;
                }
                ind = i;
                while(ind<n && a[ind][0]<=cur+1){
                    if(a[ind][0]==cur+1 && a[ind][1]==0) right = true;
                    ind++;
                }
            }
            if(right && left) ans++;
        }
        fw.println(ans);
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
