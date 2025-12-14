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
        int a[] = fr.nextIntArray();
        int c[] = fr.nextIntArray();
        int p[] = fr.nextIntArray();

        ArrayList<Integer> b = new ArrayList<>();
        long ans = 0;
        int d1[] = new int[n];
        int d2[] = new int[n];
        int e[][] = new int[n][2];
        int f[] = new int[n];
        Arrays.fill(f, -1);
        for(int i=0;i<n;i++){
            d1[i] = i;
            d2[i] = i;
            e[i][0] = c[i];
            e[i][1] = i;
        }
        Arrays.sort(e, (x,y)->x[0] - y[0]);
        for(int i=0;i<n;i++){
            int val = a[e[i][1]];
            int ind = e[i][1];
            if(f[ind]!=-1) continue;
            while(ind >= 0 && a[ind] <= val){
                f[ind] = e[i][0];
                b.add(e[i][0]);
                ans += e[i][0]; 
                ind--;
                if(ind >= 0) ind = d1[ind];
            }
            int lef = ind;
            ind = e[i][1] + 1;
            if(ind < n) ind = d2[ind];
            while(ind < n && a[ind] <= val){
                f[ind] = e[i][0];
                b.add(e[i][0]);
                ans += e[i][0]; 
                ind++;
                if(ind < n) ind = d2[ind];
            }
            // fw.println(lef + " " + ind);
            d2[lef+1] = ind;
            d1[ind-1] = lef;
        }
        for(int i=0;i<n;i++){
            d1[i] = i;
            d2[i] = i;
        }
        // fw.println(b);
        Map<Integer, Integer> map = new HashMap<>();
        fw.print((ans - b.get(b.size()-1))+ " ");
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            int ind = p[i]-1;
            int val = a[ind];
            if(vis[ind]){
                int temp = 0;
                if(b.size() > 0) temp = b.get(b.size()-1);
                fw.print((ans - temp) + " ");
                continue;
            }
            while(ind >= 0&& a[ind] <= val){
                vis[ind] = true;
                ans -= f[ind];
                map.put(f[ind], map.getOrDefault(f[ind], 0) + 1);
                ind--;
                if(ind >= 0) ind = d1[ind];
            }
            int lef = ind;
            ind = p[i];
            if(ind < n) ind = d2[ind];
            while(ind < n && a[ind] <= val){
                vis[ind] = true;
                ans -= f[ind];
                map.put(f[ind], map.getOrDefault(f[ind], 0) + 1);
                ind++;
                if(ind < n) ind = d2[ind];
            }
            d2[lef+1] = ind;
            d1[ind-1] = lef;
            while(b.size() > 0 && map.containsKey(b.get(b.size()-1))){
                if(map.get(b.get(b.size()-1)) == 1) map.remove(b.get(b.size()-1));
                else map.put(b.get(b.size()-1), map.get(b.get(b.size()-1))-1);
                b.remove(b.size()-1);
            }
            long cur = ans;
            if(b.size() > 0) cur -= b.get(b.size()-1);
            fw.print(cur + " ");
        }
        fw.println("");
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
