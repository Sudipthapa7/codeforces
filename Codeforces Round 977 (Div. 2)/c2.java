import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class c2 {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int m = fr.nextInt();
        int q = fr.nextInt();
        int a[] = fr.nextIntArray();
        int b[] = fr.nextIntArray();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int first[] = new int[n+1];
        Arrays.fill(first, m+1);
      int index[] = new int[n+1];
       for(int i =0;i<n;i++) index[a[i]] = i;
       for(int i=0;i<m;i++){
            if(first[b[i]]==m+1) first[b[i]] = i;
            list.get(b[i]).add(i);
       }
       boolean rec[] = new boolean[n+1];
       int cnt = 0;
       for(int i=0;i<n-1;i++){
            if(first[a[i]] <= first[a[i+1]]){
                rec[a[i]] = true;
                cnt++;
            }
       }
       if(cnt==n-1)fw.println("YA");
       else fw.println("TIDAK");
       for(int i=0;i<q;i++){
            int ind = fr.nextInt()-1;
            int val = fr.nextInt();
            //remove the existing element
            int old = b[ind];
            if(old==val){
                if(cnt==n-1)fw.println("YA");
                else fw.println("TIDAK");
                continue;
            }
            b[ind] = val;
            int x  = bs(list.get(old), ind);
            list.get(old).remove(x);
            first[old] = (list.get(old).size()==0?(m+1):list.get(old).get(0));
            int z = index[old];
            x  = bs(list.get(val), ind);
            list.get(val).add(x, ind);
            first[val] = list.get(val).get(0);
            if(z!=0){
                if(first[a[z-1]]<=first[a[z]]){
                    if(rec[a[z-1]]==false){
                        rec[a[z-1]] = true; cnt++;
                    }
                }
                else{
                    if(rec[a[z-1]]){
                        rec[a[z-1]] = false;
                        cnt--;
                    }
                }
            }
            if(z!=n-1){
                if(first[a[z]]<=first[a[z+1]]){
                    if(rec[a[z]]==false){
                        rec[a[z]] = true; cnt++;
                    }
                }
                else{
                    if(rec[a[z]]){
                        rec[a[z]] = false;
                        cnt--;
                    }
                }
            }
            //add the new element at new index
            z = index[val];
            if(z!=0){
                if(first[a[z-1]]<=first[a[z]]){
                    if(rec[a[z-1]]==false){
                        rec[a[z-1]] = true; cnt++;
                    }
                }
                else{
                    if(rec[a[z-1]]){
                        rec[a[z-1]] = false;
                        cnt--;
                    }
                }
            }
            if(z!=n-1){
                if(first[a[z]]<=first[a[z+1]]){
                    if(rec[a[z]]==false){
                        rec[a[z]] = true; cnt++;
                    }
                }
                else{
                    if(rec[a[z]]){
                        rec[a[z]] = false;
                        cnt--;
                    }
                }
            }
            // for(int j : first) System.out.print(j+" ");
            // System.out.println();
            // System.out.println(cnt);
            if(cnt==n-1)fw.println("YA");
            else fw.println("TIDAK");
       }

    }
    public static int bs(ArrayList<Integer> list, int val){
        int low = 0;
        int high = list.size();
        while(low<high){
            int mid = low + (high-low)/2;
            if(list.get(mid)>=val){
                high = mid;
            }
            else low = mid+1;
        }
        return high;
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