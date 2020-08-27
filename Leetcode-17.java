//bfs
class Solution {
    public String[]word={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        List<String>res=new ArrayList<>();
        Queue<String>q=new LinkedList<>();
        int c=(int)(digits.charAt(0)-'2');
        for(char m:word[c].toCharArray())
            q.offer(m+"");
        if(digits.length()==1){
            for(char m:word[c].toCharArray())
                res.add(m+"");
            return res;
        }
        for(int i=1;i<digits.length();i++){
            c=(int)(digits.charAt(i)-'2');
            int size=q.size();
            for(int j=0;j<size;j++){
                String s=q.poll();
                for(char m:word[c].toCharArray()){
                    if(i==digits.length()-1)res.add(s+m);
                    else q.offer(s+m);
                }
            }
        }
        return res;
    }
}
