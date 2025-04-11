import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class g {
    static class Trie{
        Trie one, zero;
        int ind;
        public Trie(int ind){
            this.one = null;
            this.zero = null;
            this.ind = ind; 
        }

    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();
        int a[] = fr.nextIntArray();
        if(k==0){
            fw.println(1);
            return;
        }
        Trie root = new Trie(n+2);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ind = -1;
            Trie cur = root;
            for(int j=30;j>=0;j--){
                int req = ((1<<j)&k)==0?0:1;
                int val = ((1<<j)&a[i])==0?0:1;
            //     if(i==1){System.out.print(req + " " + val + " "+cur.ind+" ");
            //     if(cur.zero==null) System.out.println("z-null ");
            //     else System.out.print(cur.zero.ind + " ");
            //     if(cur.one==null) System.out.print("o-null ");
            //     else System.out.print(cur.one.ind+" ");
            //     System.out.println();
            // }
                if(req==0){
                    if(val==0 && cur.one!=null) ind = Math.max(ind, cur.one.ind);
                    if(val==1 && cur.zero!=null) ind = Math.max(ind, cur.zero.ind);
                    if(val ==0 && cur.zero!=null){
                        if(j==0) ind = Math.max(ind, cur.zero.ind);
                        cur = cur.zero;
                    }
                    else if(val==1 && cur.one!=null){
                        if(j==0) ind = Math.max(ind, cur.one.ind);
                        cur = cur.one;
                    }
                    else break;
                }
                else{
                    if(val==0 && cur.one!=null){
                        cur = cur.one;
                        if(j==0) ind = Math.max(ind, cur.ind);
                    }
                    else if(val==1 && cur.zero!=null){
                        cur = cur.zero;
                        if(j==0) ind = Math.max(ind, cur.ind);
                    }
                    else break;
                }
            }
            if(ind > -1){
                ans = Math.min(ans, i-ind +1);
            }
            //System.out.println(ind);
            cur = root;
            for(int j=30;j>=0;j--){
                int val = ((1<<j)&a[i])==0?0:1;
                if(val==0){
                    if(cur.zero==null) cur.zero = new Trie(i);
                    else cur.zero.ind = Math.max(cur.zero.ind, i);
                    cur  = cur.zero;
                }
                else{
                    if(cur.one==null) cur.one = new Trie(i);
                    else cur.one.ind = Math.max(cur.one.ind, i);
                    cur  = cur.one;
                }
            }
        }
        if(ans==Integer.MAX_VALUE) ans = -1;
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
