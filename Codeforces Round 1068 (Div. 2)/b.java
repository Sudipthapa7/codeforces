import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class b{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = fr.nextIntArray();

        long MAX = (long)1e16;
        long MIN = -1L * MAX;
        long c[] = new long[4];
        for(int i=0;i<n;i++){
            long max1 = MIN, min1 = MAX;
            long temp[] = new long[4];
            ArrayList<Long> list = new ArrayList<>();
            for(int j=0;j<4;j++){
                if(c[j]==MIN || c[j]==MAX) continue;
                long cur = c[j] - a[i];
                list.add(cur);
                max1 = Math.max(max1, cur);
                min1 = Math.min(min1, cur);
            }
            for(int j=0;j<4;j++){
                if(c[j]==MIN || c[j]==MAX) continue;
                long cur = b[i] - c[j];
                list.add(cur);
                max1 = Math.max(max1, cur);
                min1 = Math.min(min1, cur);
            }
            temp[0] = min1;
            temp[1] = max1;
            temp[2] = MIN;
            temp[3] = MIN;
            if(i==n-1){
                c = temp;
                continue;
            }
            Collections.sort(list);
            int j = 0;
            while(j<list.size() && list.get(j) <= b[i+1]) {temp[2] = list.get(j); j++;}
            j = list.size()-1;
            while(j>=0 && list.get(j) >= a[i+1]){ temp[3] = list.get(j); j--;}
            c = temp;
            // for(j=0;j<4;j++) fw.print(c[j]+" ");
            // fw.println("");
        }
        long ans = MIN;
        for(long i : c) if(i==MAX || i==MIN)continue;
        else ans = Math.max(ans, i);
        fw.println(ans);
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
