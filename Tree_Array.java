package struct_data;

import java.util.Scanner;

public class Tree_Array {
    private static int[]tree=new int[501];
    public static int lowbit(int x){
        return x&(-x);
    }
    public static void add(int index,int k){
        while(index<tree.length){
            tree[index]+=k;
            index+=lowbit(index);
        }
    }
    public static int get(int x){
        int sum=0;
        while(x>0){
            sum+=tree[x];
            x-=lowbit(x);
        }
        return sum;
    }
    public static int get_sum(int x,int y){
        return get(y)-get(x-1);
    }
    public static void main(String[]arg_s){
        Scanner in=new Scanner(System.in);
        for(int i=1;i<11;i++){
            add(i,in.nextInt());
        }
        int m=in.nextInt();//操作次数,1为向下标为index的数加上k,2为查询[x,y]的和
        for(int i=0;i<m;i++){
            if(in.nextInt()==1){
                int index=in.nextInt();
                int k=in.nextInt();
                add(index,k);
            }
            else{
                int x=in.nextInt();
                int y=in.nextInt();
                System.out.println(get_sum(x,y));
            }
        }
    }
}
