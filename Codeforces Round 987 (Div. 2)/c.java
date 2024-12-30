import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class c {
    static ArrayList<Integer> list= new ArrayList<>();
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        if(n%2==0){
            for(int i=0;i<n;i+=2){
                fw.print((i+1)+" "+(i+1)+" ");
            }
            fw.println("");
            return;
        }
        if(n<27){
            fw.println(-1);
            return;
        }
        int a[] = new int[28];
        a[1] = 1;
        a[10] = 1;
        a[26] = 1;
        a[11] = 2;
        a[27] = 2;
        int cnt = 3;
        for(int i=2;i<10;i+=2){
            a[i] = cnt; a[i+1] = cnt;
            cnt++;
        }
        for(int i=12;i<26;i+=2){
            a[i] = cnt;a[i+1] = cnt;
            cnt++;
        }
        // for(int i=0;i<28;i++){
        //     for(int j=i+1;j<28;j++) if(a[i]==a[j]) System.out.println(j-i);
        // }
        for(int i=1;i<28;i++){
            fw.print(a[i]+" ");
        }
        n-= 27;
        while(n>0){
            fw.print(cnt + " " + cnt+" ");
            cnt++;
            n-=2;
        }
        fw.println("");
        // if(n%2==0){
        //     int cnt = 1;
        //     for(int i=0;i<n/2;i++){
        //         fw.print(cnt +" " + cnt+" ");
        //         cnt++;
        //     }
        //     fw.println("");
        //     return;
        // }
        // if(n<=25){
        //     fw.println(-1);
        //     return;
        // }
        // for(int i=0;i<Math.min(n, 41);i++) fw.print(list.get(i)+" ");
        // n-=41;
        // int cnt = 20;
        // for(int i=0;i<n/2;i++){
        //     fw.print(cnt+" "+cnt+" ");
        //     cnt++;
        // }S
        // fw.println("");
        // for(int i =0;i<41;i++){
        //     for(int j=i+1;j<41;j++){
        //         if(list.get(i)==list.get(j)) System.out.println(j-i);
        //     }
        // }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int cnt = 1;
        for(int i=0;i<9;i++){
            list.add(cnt);
            cnt++;
        }
        list.add(cnt);
        cnt++;
        for(int i=0;i<3;i++){
            list.add(cnt);
            list.add(cnt);
            cnt++;
        }
        cnt = 1;
        for(int i=0;i<9;i++){
            list.add(cnt);
            cnt++;
        }
        list.add(cnt);
        cnt = 1;
        for(int i=0;i<9;i++){
            list.add(cnt);
            cnt++;
        }
        cnt++;
        cnt = 15;
        for(int i=0;i<3;i++){
            list.add(cnt);
            list.add(cnt);
            cnt++;
        }
        //System.out.println(list);
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
