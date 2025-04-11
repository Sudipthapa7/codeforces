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
        while(q-->0){
            String s = fr.next();
             if(s.charAt(0)=='-') 
             fw.println(find(s, n));
             else find1(s, n);
        }
    //     fw.println(find(null, n, 1, 2));
    //     for(int i=0;i<1<<2*n;i++){
    //         String s = "";
    //         // if(s.charAt(0)=='-') 
    //         //fw.print(find(s, n, i+1, j+1)+" ");
    //         find1(s, n, i+1);
    // }
    }
    public static void find1(String s, int n){
        long val = fr.nextLong();
        // int ind = 2;
        // while(ind < s.length()){
        //     val = val * 10 + (s.charAt(ind)-'0');
        //     ind++;
        // }
        int x1 = 1, y1 = 1, x2 = 1<<n, y2 = 1<<n;
        long min = 1, max = 1L << (2 * n);
        while(min < max){
            int mid = x1 - 1+ (x2 - x1 + 1) / 2;
            int mid2 = y1 - 1 + (y2 - y1 + 1) / 2;
            long a = (max - min + 1)/4;
            //System.out.println(mid + " " + mid2 + " " + a);
            if(val < min + a){
                x2 = mid;
                y2 = mid2;
                max = min + a - 1;
            }
            else if(val < min + 2 * a){
                x1  = mid + 1;
                y1  = mid2 + 1;
                max = min + 2 * a - 1;
                min = min + a;
            }
            else if(val < min + 3 * a){
                x1  = mid + 1;
                y2 = mid2;
                max = min + 3 * a - 1;
                min = min + 2 * a;
            }
            else{
                x2 = mid;
                y1  = mid2 + 1;
                min = min + 3 * a;
            }
            //System.out.println(x1 +" " + x2 + "; "+y1 + " " + y2 + "; " + min + " " + max);
        }
        fw.println(x1 + " " + y1);
    }
    public static long find(String s, int n){
        int x = fr.nextInt(), y = fr.nextInt();
        int x1 = 1; int y1 = 1;
        long min = 1;
        long max = 1L << (2*n);
        int x2 = 1<<n, y2 = 1<<n;
        while(min < max){
            long a = (max - min + 1) / 4;
            int mid = x1 - 1 + (x2 - x1 + 1) / 2;
            int mid2 = y1 - 1 + (y2 - y1 + 1) / 2;
            //System.out.println(mid + " " + mid2 + " " + a);
            if(x <=mid && y<=mid2){
                max = min + a -1;
                x2 = mid;
                y2 = mid2;
            }
            else if(x > mid && y > mid2){
                max = min + (2 * a) - 1;
                min = min + a;
                x1  = mid + 1;
                y1  = mid2 + 1;
            }
            else if(x> mid && y <= mid2){
                max = min + (3 * a) - 1;
                min = min + 2 * a;
                x1 = mid+1;
                y2 = mid2;
            }
            else {
                min = min + 3 * a;
                y1  = mid2 + 1;
                x2 = mid;
            }
           //System.out.println(x1 +" " + x2 + "; "+y1 + " " + y2 + "; " + min + " " + max);
        }
        return max;
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