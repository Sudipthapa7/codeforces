import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class a {
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static boolean solve(){
       int n = fr.nextInt();
       int a = fr.nextInt();
       int b = fr.nextInt();
       String s = fr.next();
    
       int x = 0, y = 0;
       //int arr[][] = new int[n][2];
    //    for(int i[] : arr) Arrays.fill(i, -1);
    //    arr[n-1][0] = 0;
    //    arr[n-1][1] = 0;
       for(int j=0;j<100;j++){
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='N') y++;
            if(s.charAt(i)=='S') y--;
            if(s.charAt(i)=='E') x++;
            if(s.charAt(i)=='W') x--;
            if(a==x && b==y) return true;
            // if(x>40 || x<-40 || y>40 || y<-40) return false;
            // if(arr[i][0] ==x && arr[i][1] == y) return false;
            // arr[i][0] = x;
            // arr[i][1] = y;
        } 
        // int val = Math.abs(a-x) + Math.abs(b-y);
        // if(val>=diff) break;
        // diff = val;   
       }
       return false;
    //    int arr[][] = new int[n][2];
    //    int x = 0, y = 0;
    //    for(int i=0;i<n;i++){
    //         if(s.charAt(i)=='N') y++;
    //         if(s.charAt(i)=='S') y--;
    //         if(s.charAt(i)=='E') x++;
    //         if(s.charAt(i)=='W') x--;
    //         if(a==x && b==y) return true;
    //         arr[i][0] = x;
    //         arr[i][1] = y;
    //    }
    //    //for(int i=0;i<n;i++)System.out.println("arr"+arr[i][0] + " " + arr[i][1]);
    //    if(x==0 && y==0) return false;
    //    //System.out.println(x + " "+y);
    //    for(int i=0;i<n;i++){
    //     int rx = a - arr[i][0];
    //     int ry = b - arr[i][1];
    //     // System.out.println("arr"+rx + " " + x);
    //     // System.out.println(ry + " " + y);
    //     if(x==0){
    //         if(ry%y==0) return true;
    //     }
    //     else if(y==0){
    //         if(rx%x==0) return true;
    //     }
    //     else if(rx%x==0 &&  ry%y==0){
    //         // System.out.println(rx/x);
    //         // System.out.println(ry/y);
    //         if(rx/x == ry/y) return true;
    //     }

    //    }
    //    return false;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        //long start = System.nanoTime();
        int t = fr.nextInt();
        //System.out.println(solve());
        //System.out.println(solve()?"YES":"NO");
        while(t-->0){
            //solve();
            //System.out.println(solve());
            System.out.println(solve()?"YES":"NO");
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