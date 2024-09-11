import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class g1 {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static int find(ArrayList<Integer> list, int val){
        int low  = 0, high = list.size();
        int ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid)<=val){
                ans = mid;
                low = mid+1;
            }
            else high = mid;
        }
        return ans;
    }
    public static int find2(ArrayList<Integer> list, int val){
        int low  = 0, high = list.size();
        int ans = 0;
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid)>=val){
                ans = mid;
                high  = mid;
            }
            else low = mid+1;
        }
        return ans;
    }
    public static void solve(){
        int n = fr.nextInt();
        int k = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = new int[n];
        for(int i=0;i<n;i++) b[i] = a[i]-i;
        int ans[] = new int[n-k+1];
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
             map.put(b[i], map.getOrDefault(b[i], 0)+1);
             if(map.get(b[i])==1) list.add(0,1);
             else{
                int ind = find(list, map.get(b[i])-1);
                list.set(ind, list.get(ind)+1);
             }
        }
        ans[0] = list.get(list.size()-1);
        //System.out.println(list);
        for(int i=k;i<n;i++){
            map.put(b[i], map.getOrDefault(b[i], 0)+1);
             if(map.get(b[i])==1) list.add(0,1);
             else{
                int ind = find(list, map.get(b[i])-1);
                list.set(ind, list.get(ind)+1);
             }
             int j = i-k;
             if(map.get(b[j])==1){
                map.remove(b[j]);
                list.remove(0);
                ans[i-k+1] = list.get(list.size()-1);
                continue;
             }
             map.put(b[j], map.get(b[j])-1);
             int ind  = find2(list, map.get(b[j])+1);
             list.set(ind, list.get(ind)-1);
             ans[i-k+1] = list.get(list.size()-1);
             //System.out.println(list);
        }
        //for(int i=0;i<ans.length;i++) System.out.print(ans[i]+" ");
        //System.out.println();
        for(int i=0;i<q;i++){
            int l = fr.nextInt();
            int r = fr.nextInt();
            fw.println(k-ans[l-1]);
        }
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
