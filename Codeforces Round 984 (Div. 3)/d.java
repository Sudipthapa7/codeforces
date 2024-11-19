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
    static int[] num = new int[]{5, 4, 3};
    public static void solve(){
        int n = fr.nextInt();
        int m = fr.nextInt();
        int a[][] = new int[n][m];
        for(int i=0;i<n;i++){
           String s = fr.next();
           for(int j=0;j<m;j++)a[i][j] = s.charAt(j) - '0';
        }
        int ans = 0;
        int l = 0, r = m-1, d = n-1, u = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(l<r && u<d){
            list.clear();
            for(int i=l;i<=r;i++) list.add(a[u][i]);
            u++;
            for(int i=u;i<=d;i++) list.add(a[i][r]);
            r--;
            for(int i=r;i>=l;i--) list.add(a[d][i]);
            d--;
            for(int i=d;i>=u;i--) list.add(a[i][l]);
            l++;
            for(int i=0;i<3;i++) list.add(list.get(i));
            //System.out.println(list);
            for(int i=0;i<list.size()-3;i++){
                if(list.get(i)==1 && list.get(i+1)==5 && list.get(i+2)==4 && list.get(i+3)==3) ans++;
            }
        }
        fw.println(ans);
    }
    // public static int find(int[][] a, int i, int j, int dir, int ind, int n , int m){
    //     if(i<0 || j<0 || i>=n || j>=m) return 0;
    //     if(a[i][j]!=num[ind]) return 0;
    //     if(ind==2) return 1;
    //     int ans = 0;
    //     if(dir==1){
    //         ans += find(a, i-1, j, 1, ind+1, n, m);
    //         ans += find(a, i, j+1, 2, ind+1, n, m);
    //     }
    //     else if(dir==2){
    //         ans += find(a, i+1, j, 3, ind+1, n, m);
    //         ans += find(a, i, j+1, 2, ind+1, n, m);
    //     }
    //     else if(dir==3){
    //         ans += find(a, i+1, j, 3, ind+1, n, m);
    //         ans += find(a, i, j-1, 4, ind+1, n, m);
    //     }
    //     else{
    //         ans += find(a, i-1, j, 1, ind+1, n, m);
    //         ans += find(a, i, j-1, 4, ind+1, n, m);
    //     }
    //     return ans;
    // }
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
