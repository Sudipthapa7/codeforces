import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d {
    static boolean found;
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    static int[][] a;
    public static void solve(){
        int n = fr.nextInt();
        a = new int[3][n+1];
        for(int i=0;i<3;i++) for(int j=0;j<n;j++) a[i][j] = fr.nextInt();
        int dp[][] = new int[3][n];
        int from[] = new int[n];
        for(int i[] : dp) Arrays.fill(i, -1);
        int max[][] = new int[3][2];
        for(int i=0;i<3;i++) max[i][0] = a[i][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(a[j][i] < max[j][0]){
                    for(int k=0;k<3;k++){
                        if(a[k][i] > max[k][0]){
                            max[k][0] = a[k][i];
                            max[k][1] = i;
                        }
                        from[i] = j;
                        dp[k][i] = max[j][1];
                    }
                    break;
                }
            }
            // for(int j=0;j<3;j++)System.out.print(max[j][0]+ " ");
            // System.out.println();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(dp[i][n-1]!=-1){
                int j = n-1;
                while(dp[i][j]!=-1){
                    List<Integer> list = new ArrayList<>();
                    list.add(from[j]); list.add(j+1);
                    ans.add(list);
                    j = dp[i][j];
                }
                break;
            }
        }
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<n;j++) System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }
        if(ans.size()==0){
            fw.println("NO");
            return;
        }
        fw.println("YES");
        fw.println(ans.size());
        for(int i=ans.size()-1;i>=0;i--){
            if(ans.get(i).get(0)==0)fw.print("q ");
            else if(ans.get(i).get(0)==1) fw.print("k ");
            else fw.print("j ");
            fw.println(ans.get(i).get(1));
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
