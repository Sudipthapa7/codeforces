import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static class Pair{
        int ind, val;
        public Pair(int ind, int val){
            this.val = val;
            this.ind = ind;
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int a[] = fr.nextIntArray();

        int max[] = new int[n];
        max[0] = a[0];
        for(int i=1;i<n;i++){
            max[i] = Math.max(a[i], max[i-1]);
        }
        int ans[] = new int[n];

        ArrayList<Pair> list = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(list.size()==0){
                ans[i] = max[i];
                list.add(new Pair(i, a[i]));
                continue;
            }
            ans[i] = max[i];
            // for(int j=0;j<list.size();j++)System.out.print(list.get(j).val+" ");
            // System.out.println();
            int index =  bs(list, a, max[i]);
            // System.out.println(i+" "+index);
            if(a[i]<list.get(list.size()-1).val){
                list.add(new Pair(i, a[i]));
            }
            if(index!=-1) ans[i] = Math.max(ans[i], ans[index]);
        }
        for(int i=0;i<n;i++) fw.print(ans[i]+" ");
        fw.println("");
    }
    public static int bs(ArrayList<Pair> list, int a[], int val){
        int low = 0;
        int high = list.size();
        int ans = -1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(list.get(mid).val<val){
                ans = list.get(mid).ind;
                high = mid;
            }
            else low = mid+1;
        }
        
        return ans;
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
