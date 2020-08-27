package struct_data;

import java.util.Arrays;
import java.util.Scanner;

public class Kruscal {
        public static int[][]val=new int[200000][3];
        public static int find(int a,int[]node){
            if(node[a]==a)return a;
            node[a]=find(node[a],node);
            return node[a];
        }
        public static void main(String[]arg_s){
            Scanner in=new Scanner(System.in);
            int N,M,res=0;
            N=in.nextInt();
            M=in.nextInt();
            int[]node=new int[N+1];
            for(int i=1;i<=N;i++)
                node[i]=i;
            for(int i=0;i<M;i++){
                val[i][0]=in.nextInt();
                val[i][1]=in.nextInt();
                val[i][2]=in.nextInt();
            }
            Arrays.sort(val,0,M,(a, b)->a[2]-b[2]);
            for(int i=0;i<M;i++){
                int a=find(node[val[i][0]],node);
                int b=find(node[val[i][1]],node);
                if(a!=b)res+=val[i][2];
                node[a]=b;
                node[val[i][0]]=b;
            }
            System.out.println(res);
        }
}


