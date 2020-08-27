package struct_data;


import java.util.Scanner;
public class KMP {
    public static int search(int[]next,String str1,String str2){
        int tar=0,pos=0;
        while(tar<str1.length()&&pos<str2.length()){
            if(pos==-1||str1.charAt(tar)== str2.charAt(pos)){
                tar++;
                pos++;
            }
            else pos=next[pos];
            if(pos==str2.length()){
                return tar-pos+1;
            }
        }
        return -1;
    }
    public static void build_next(int[]next,String str){
        int i=0,now=-1;
        while(i<str.length()-1){
            if(now==-1||str.charAt(i)== str.charAt(now)){
                now++;
                i++;
                if (str.charAt(i)!= str.charAt(now))
                    next[i]=now;
                else next[i]=next[now];
            }
            else now=next[now];
        }
    }
    public static void main(String[]arg_s){
        Scanner in=new Scanner(System.in);
        String main_str="kqwuuiqiwwuuqajxaiqwuuiwqjajxncbka";
        String pattern="qwuuiw";
        int[]next=new int[pattern.length()+1];
        next[0]=-1;
        build_next(next,pattern);
        System.out.println(search(next,main_str,pattern));
    }
}
