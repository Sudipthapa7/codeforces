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
    //static ArrayList<ArrayList<Integer>> loop;
    public static int dfs(int[] p, int[] arr, int ind, Set<Integer> set, String s){
        if(arr[ind]!=-1) return arr[ind];
        if(set.contains(p[ind]-1)){
            int val = 0;
            set.add(ind);
            if(s.charAt(ind)=='0') val = 1;
            //System.out.println(ind+" "+val);
            return arr[ind] = val;
        }
        set.add(ind);
        int cnt = dfs(p, arr, p[ind]-1, set, s);
        if(s.charAt(ind)=='0') cnt++;
        //System.out.println(ind+" "+cnt);
        return arr[ind] = cnt;
    }
    public static void solve(){
        int n = fr.nextInt();
        int p[] = fr.nextIntArray();
        String s = fr.next();
        int arr[] = new int[n];
        //loop = new ArrayList<>();
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++){
            if(arr[i]==-1){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                arr[i] = dfs(p, arr, i, set,s);
                for(int j : set){
                    arr[j] = arr[i];
                }
            }
        }
        //System.out.println(loop);
        // for(int i=0;i<loop.size();i++){
        //     arr[loop.get(i).get(0)] = arr[loop.get(i).get(1)];
        // }
        for(int i=0;i<n;i++) fw.print(arr[i]+" ");
        fw.println("");

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
