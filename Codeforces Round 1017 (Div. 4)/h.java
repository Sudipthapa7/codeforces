import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class h {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(a[i])) map.put(a[i], new ArrayList<>());
            map.get(a[i]).add(i);
        }
        while(q-->0){
            int k = fr.nextInt();
            int l = fr.nextInt()-1;
            int r = fr.nextInt()-1;
            long ans = 0;
            int ind = l;
            int val = k;
            while(ind<=r){
                ind = r + 1;
                for(int i=2;i<=Math.sqrt(k);i++){
                    if(k%i==0 && map.containsKey(i)){
                        int cur = bs(map.get(i), l, n);
                        if(cur <= ind){
                            val = k/i;
                            ind = cur;
                        }
                    }
                    if(k%i==0 && map.containsKey(k/i)){
                        int cur = bs(map.get(k/i), l, n);
                        if(cur <= ind){
                            val = i;
                            ind = cur;
                        }
                    }
                }
                if(map.containsKey(k)){
                    int cur = bs(map.get(k), l, n);
                    //fw.println(cur);
                    if(cur <= ind){
                        val = 1;
                        ind = cur;
                    }
                }
               // System.out.println(ans + " " + ind+" " + l);
                ans += 1L * (Math.min(ind, r+1) - l) * k;
                //System.out.println(ans);
                l = ind ;
                k = val;
                //fw.println(ans + " " + l+" " + k+" " + val);
            }
            fw.println(ans);
        }
    }
    public static int bs(ArrayList<Integer> list, int val, int n){
        int low = 0;
        int high = list.size();
        int ans = n;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(list.get(mid)>=val) {
                ans = list.get(mid);
                high = mid;
            }
            else low = mid + 1;
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