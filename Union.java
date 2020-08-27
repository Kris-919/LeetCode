package struct_data;
import java.util.*;
public class Union {
        public static void union(int a,int b,int[]node){
            int c=find(node[a],node);
            int d=find(node[b],node);
            node[c]=d;
            node[a]=d;
        }
        public static int find(int a,int[]node){
            if(node[a]==a)return a;
            node[a]=find(node[a],node);
            return node[a];
        }
        public static void main(String[]arg_s){
            Scanner in=new Scanner(System.in);
            int N,M,z,x,y;
            N=in.nextInt();
            M=in.nextInt();
            int[]node=new int[N+1];
            for(int i=1;i<=N;i++){
                node[i]=i;
            }
            for(int i=0;i<M;i++){
                z=in.nextInt();
                x=in.nextInt();
                y=in.nextInt();
                if(z==1){
                    union(node[x],node[y],node) ;
                }
                else{
                    int a=find(node[x],node);
                    int b=find(node[y],node);
                    if(a==b)System.out.println("Y");
                    else System.out.println("N");
                }
            }
        }
}

