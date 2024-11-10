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
    public static void solve(){
        int n = fr.nextInt();
        int q = fr.nextInt();
        int[] p = fr.nextIntArray();
        char[] s = fr.next().toCharArray();
        boolean ok[] = new boolean[n];
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, p[i]);
            if(max==i+1) ok[i] = true;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n-1;i++){
            if(s[i]=='L' && s[i+1]=='R'){
                if(!ok[i]) set.add(i);
            }
        }
        for(int i=0;i<q;i++){
            int ind = fr.nextInt();
            ind--;
            if(s[ind]=='L'){
                s[ind] = 'R';
                if(s[ind-1]=='L' && !ok[ind-1]) set.add(ind-1);
                if(s[ind+1] == 'R' && set.contains(ind)) set.remove(ind);
            }
            else{
                s[ind] = 'L';
                if(s[ind-1]=='L' && set.contains(ind-1)) set.remove(ind-1);
                if(s[ind+1]=='R' && !ok[ind]) set.add(ind);
            }
            if(set.size()==0) fw.println("YES");
            else fw.println("NO");
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