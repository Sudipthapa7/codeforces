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
    static ArrayList<Integer> list;
    static boolean found;
    static ArrayList<ArrayList<Integer>> tree;
    static int cnt;
    static int n;
    public static void solve(){
        n = fr.nextInt();
        tree = new ArrayList<>();
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        list = new ArrayList<>();
        cnt = 0;
        found = false;
        dfs(0, -1);
 
        int i = 0;
        int j = list.size()-1;
 
        while(j - i > 2){
            int y = q(list.get(i+1), list.get(j-1));
            if(y == 0){
                int z = q(list.get(i), list.get(i));
                if(z==1){
                    fw.println("! " + list.get(i));
                }
                else fw.println("! " + list.get(j));
                return;
            }
            i++;
            j--;
        }
        for(;i<j;i++){
            if(q(list.get(i), list.get(i))==1){ fw.println("! " + list.get(i)); return;}
        }
        fw.println("! " + list.get(j));
    }
    public static void dfs(int node, int par){
        if(found) return;
        list.add(node+1);
        int x = 0;
        cnt++;
        for(int i : tree.get(node)) if(i!=par){
            x++;
            dfs(i, node);
        }
        if(cnt == n){
            found = true;
            return;
        }
        if(x==0 && list.size() > 1){
            int y = q(list.get(0), list.get(list.size()-1));
            if(y==1){
                found = true;
                return;
            }
            else list.clear();
        }
    }
    public static int q(int x, int y){
        fw.println("? " + x + " " + y);
        fw.flush();
        return fr.nextInt();
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
