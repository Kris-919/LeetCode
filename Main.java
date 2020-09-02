package struct_data;

import java.util.*;

public class Main {
    public static int[]vis,res,fa,vis1;
    public static Map<Integer,List<Integer>>map;
    public static Map<Integer,List<Integer[]>>con;
    public static int find(int a){
        if(fa[a]==a)return a;
        fa[a]=find(fa[a]);
        return fa[a];
    }
    public static void union(int x,int y){
        x=find(x);
        y=find(y);
        fa[y]=x;
    }
    public static void dfs(int s){
        vis1[s]=1;
        for(Integer c:map.get(s)){
            if(vis1[c]==0) {
                dfs(c);
                union(s, c);
            }
        }
        vis[s] = 1;
        for(Integer[]c:con.get(s)){
            if(vis[c[0]]==1&&res[c[1]]==0)res[c[1]]=find(c[0]);
        }
    }
    public static void main(String[]arg_s){
        int N,M,S;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        S=sc.nextInt();
        vis=new int[N+1];
        vis1=new int[N+1];
        res=new int[M];
        fa=new int[N+1];
        map=new HashMap<>();
        con=new HashMap<>();
        for(int i=1;i<=N;i++){
            map.put(i,new ArrayList<>());
            con.put(i,new ArrayList<>());
            fa[i]=i;
        }
        for(int i=0;i<N-1;i++){
            int x=sc.nextInt(),y=sc.nextInt();
            map.get(x).add(y);
            map.get(y).add(x);
        }
        for(int i=0;i<M;i++){
            int x=sc.nextInt(),y=sc.nextInt();
            con.get(x).add(new Integer[]{y,i});
            con.get(y).add(new Integer[]{x,i});
        }
        dfs(S);
        for(int i=0;i<M;i++){
            System.out.println(res[i]);
        }
    }
}
