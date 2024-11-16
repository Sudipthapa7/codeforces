import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class d{
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int ans[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(1);
        int i = 2;
        while(i<n){
            fw.println("? " + 1 +" " + i);
            fw.flush();
            int a = fr.nextInt();
            if(a==0) break;
            list.add(i);
            i++;
        }
        if(i<n) ans[i] = 1;
        list.add(0, i);
        i++;
        int ind = 1;
        while(i<n && list.size()>1){
            if(ind ==list.size()) ind = 0;
            fw.println("? " + list.get(ind) +" " + i);
            fw.flush();
            int a = fr.nextInt();
            if(a==1){
                list.remove(ind);
            }
            else{
                ans[i] = list.get(ind);
                list.set(ind, i);
                ind++;
                i++;
            }
        }
        while(i<n){ ans[i] = i-1;i++;}
        fw.print("! ");
        for(int j=1;j<n;j++)fw.print(ans[j] + " ");
        fw.println("");
        fw.flush();
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
