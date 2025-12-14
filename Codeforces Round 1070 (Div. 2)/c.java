import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class c{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();
        ArrayList<Integer> list = new ArrayList<>();
        long odd = 0;
        for(int i=0;i<n;i++){
            if(a[i] % 2==1) odd = Math.max(odd, a[i]);
            else list.add(a[i]);
        }
        Collections.sort(list);
        long ans = 0;
        int j = list.size() - 1;
        if(list.size() == 1){
            for(int i=0;i<n-1;i++){
                if(i%2==0){
                    fw.print(odd + " ");
                }
                else{
                    fw.print((odd + list.get(0)) + " ");
                }
            }
            if(n%2==0){
                fw.print((odd + list.get(0)) + " ");
            }
            else{
                fw.print(0+" ");
            }
            fw.println("");
            return;
        }
        for(int i=0;i<n;i++){
            if(odd == 0){
                fw.print(0 + " ");
                continue;
            }
            if(ans == 0){
                ans += odd;
                fw.print(ans + " ");
                continue;
            }
            if(list.size()==0){
                if(i%2==0){
                    fw.print(ans + " ");
                }
                else{
                    fw.print(0 + " ");
                }
                continue;
            }
            if(j==-1){
                if(i==n-1){
                    fw.print(0+ " ");
                    continue;
                }
                j++;
                ans -= list.get(j);
                fw.print(ans + " ");
            }
            else{
                ans += list.get(j);
                fw.print(ans + " ");
                j--;
            }
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
