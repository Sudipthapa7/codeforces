import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class g {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int q = fr.nextInt();
        long ans1 = 0;
        long sum = 0;
        long ans2 = 0;
        boolean ok = true;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int it=0;it<q;it++){
            int s = fr.nextInt();
            if(s==1){
                if(ok){
                    int elem = dq.removeFirst();
                    dq.addLast(elem);
                    ans1 = ans1 - (1L * elem * dq.size());
                    ans1 += sum;
                    ans2 -= sum;
                    ans2 += (1L * elem * dq.size());
                }
                else{
                    int elem = dq.removeLast();
                    dq.addFirst(elem);
                    ans2 = ans2 - (1L * elem * dq.size());
                    ans2 += sum;
                    ans1 -= sum;
                    ans1 += (1L * elem * dq.size());
                }
            }
            else if(s==2){
                ok = !ok;
            }
            else{
                int val = fr.nextInt();
                sum += val;
                if(ok){
                    dq.addFirst(val);
                    ans1 = ans1 + (1L *val * dq.size());
                    ans2 += sum;
                }
                else{
                    dq.addLast(val);
                    ans2 = (ans2 + 1L *val * dq.size());
                    ans1 += sum;
                }
            }
            long ans = ok?ans1 : ans2;
            fw.println(ans);
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
