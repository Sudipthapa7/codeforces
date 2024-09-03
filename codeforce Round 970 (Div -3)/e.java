import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class e {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        String s = fr.next();
        if(n%2==0){
            int cnt1[] = new int[26];
            int cnt2[] = new int[26];
            for(int i=0;i<n;i++){
                if(i%2==0){
                    cnt1[s.charAt(i)-'a']++;
                }
                else cnt2[s.charAt(i)-'a']++;
            }
            Arrays.sort(cnt1); Arrays.sort(cnt2);
            int ans = 0;
            for(int i=24;i>=0;i--){
                ans += cnt1[i];
                ans +=cnt2[i];
            }
            fw.println(ans);
            return;
        }
        int cnt1[][] = new int[n][26];
        int cnt2[][] = new int[n][26];
        cnt1[0][s.charAt(0)-'a']++;
        for(int i=1;i<n;i++){
            for(int j=0;j<26;j++){
                cnt1[i][j] = cnt1[i-1][j];
                cnt2[i][j] = cnt2[i-1][j];
            }
            if(i%2==0) cnt1[i][s.charAt(i)-'a']++;
            else cnt2[i][s.charAt(i)-'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int even[] = new int[26];
            int odd[] = new int[26];
            for(int j=0;j<26;j++){
                even[j] = cnt2[n-1][j] - cnt2[i][j];
                odd[j] = cnt1[n-1][j] - cnt1[i][j];
                if(i!=0){
                    even[j] += cnt1[i-1][j];
                    odd[j] += cnt2[i-1][j];
                }
            }
            Arrays.sort(even); Arrays.sort(odd);
            int cur = 0;
            for(int j=24;j>=0;j--){
                cur += odd[j];
                cur +=even[j];
            }
            ans = Math.min(ans, cur);
            
        }
        fw.println(ans+1);
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