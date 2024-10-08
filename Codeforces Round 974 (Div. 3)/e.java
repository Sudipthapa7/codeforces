import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class e {
    static class Pair{
        int fir;
        long sec;
        boolean hor;
        public Pair(int fir, long sec, boolean hor){
            this.fir = fir;
            this.sec = sec;
            this.hor = hor;
        }
    }
    static FastReader fr = new FastReader();
    static FastWriter fw = new FastWriter();
    public static void solve(){
        int n = fr.nextInt();
        int m  = fr.nextInt();
        int h = fr.nextInt();
        int a[] = fr.nextIntArray();
        boolean horse[] = new boolean[n];
        for(int i : a) horse[i-1] = true;
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u = fr.nextInt();
            int v = fr.nextInt();
            int w = fr.nextInt();
            u--; v--;
            g.get(u).add(new Pair(v, w, false));
            g.get(v).add(new Pair(u, w, false));
        }
        long mar[][] = new long[2][n];
        long rob[][] = new long[2][n];
        for(int i=0;i<2;i++){
            Arrays.fill(mar[i], -1);
            Arrays.fill(rob[i], -1);
        }
        PriorityQueue<Pair> mq = new PriorityQueue<>((x,y)->(Long.compare(x.sec, y.sec)));
        PriorityQueue<Pair> rq = new PriorityQueue<>((x,y)->(Long.compare(x.sec, y.sec)));
        mq.add(new Pair(0, 0, false));
        rq.add(new Pair(n-1,0, false));
        while(!mq.isEmpty()){
            Pair p = mq.poll();
            int node = p.fir;
            long time = p.sec;
            boolean ishor = p.hor;
            if(mar[1][node]!=-1) continue;
            if(!ishor && mar[0][node]!=-1) continue;
            if(ishor){
                 mar[1][node] = time;
                 mar[0][node] = (mar[0][node]==-1?time: Math.min(mar[0][node], time));
            }
            else mar[0][node] = time;
            if(horse[node]) ishor = true;
            for(Pair i : g.get(node)){
                if((ishor && mar[1][i.fir]==-1) || (!ishor && mar[0][i.fir]==-1)){
                    long new_time = time + i.sec;
                    if(ishor) new_time = time + i.sec/2;
                    mq.add(new Pair(i.fir, new_time, ishor));
                }
            }
        }
        while(!rq.isEmpty()){
            Pair p = rq.poll();
            int node = p.fir;
            long time = p.sec;
            boolean ishor = p.hor;
            if(rob[1][node]!=-1) continue;
            if(!ishor && rob[0][node]!=-1) continue;
            if(ishor){
                 rob[1][node] = time;
                 rob[0][node] = (rob[0][node]==-1?time: Math.min(rob[0][node], time));
            }
            else rob[0][node] = time;
            if(horse[node]) ishor = true;
            for(Pair i : g.get(node)){
                long new_time = time + i.sec;
                if((ishor && rob[1][i.fir]==-1) || (!ishor && rob[0][i.fir]==-1)){
                    if(ishor) new_time = time + i.sec/2;
                    rq.add(new Pair(i.fir, new_time, ishor));
                }
            }
        }
        // for(int i : mar[0])System.out.print(i+" ");
        // System.out.println();
        // for(int i : rob[0])System.out.print(i+" ");
        // System.out.println();
        long ans = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(mar[0][i]!=-1 && rob[0][i]!=-1)
            ans = Math.min(ans, Math.max(mar[0][i], rob[0][i]));
        }
        ans = ans==Long.MAX_VALUE?-1:ans;
        fw.println(ans);
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
