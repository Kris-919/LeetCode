class Solution {
    private LinkedList<String>res;
    private Map<String,PriorityQueue<String>>map;
    public void dfs(String str){
        PriorityQueue<String>pq=map.get(str);
        while(pq!=null&&pq.size()>0){
            dfs(pq.poll());
        }
        res.addFirst(str);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size()==0)return new ArrayList<>();
        map=new HashMap<>();
        for(List<String> ticket:tickets){
            if(map.containsKey(ticket.get(0)))
                map.get(ticket.get(0)).add(ticket.get(1));
            else{
                PriorityQueue<String>pq=new PriorityQueue<>();
                pq.offer(ticket.get(1));
                map.put(ticket.get(0),pq);
            }
        }
        res=new LinkedList<>();
        dfs("JFK");
        return res;
    }
}
