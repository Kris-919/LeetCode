class LFUCache {
    public Map<Integer,ListNode>map;
    public Map<Integer,DeListNode>freqMap;
    public int maxFrequent=1;
    private int size;
    public LFUCache(int capacity) {
        map=new HashMap<>(capacity);
        freqMap=new HashMap<>();
        size=capacity;
    }
    public int get(int key) {
        if(size==0)return -1;
        if(map.containsKey(key)){
            ListNode node=removeNode(key);
            addNode(node.freq,node);
            return node.value; 
        }
        else return -1;
    }
    
    public void put(int key, int value){
       if(map.containsKey(key)){
           ListNode node=removeNode(key);
           node.value=value;
           addNode(node.freq,node);
           return;
       }
        else{
           if(map.size()==size){
               for(int i=1;i<=maxFrequent;i++){
                   if(freqMap.containsKey(i)&&freqMap.get(i).count>0){
                       DeListNode denode=freqMap.get(i);
                       ListNode node=denode.removeTailNode();
                       map.remove(node.key);
                       break;
                   }
               }
           }
        ListNode newnode=new ListNode(key,value);
        map.put(key,newnode);
        addNode(1,newnode);
        }
    }

private class ListNode{
    public int key;
    public int freq=1;
    public ListNode pre;
    public ListNode next;
    public int value;
    public ListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
private class DeListNode{
    public ListNode head;
    public ListNode tail;
    public int count;
    public DeListNode(){
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);
        head.next=tail;
        tail.pre=head;
        tail.next=null;
        head.pre=null;
        count=0;
    }
    public ListNode removeTailNode(){
        ListNode old=tail.pre;
        old.pre.next=tail;
        tail.pre=old.pre;
        old.pre=null;
        old.next=null;
        count--;
        return old;
    }
    public void addHeadNode(ListNode addnode){
        ListNode old=head.next;
        head.next=addnode;
        old.pre=addnode;
        addnode.pre=head;
        addnode.next=old;
        count++;
    }
}

public void addNode(int freq,ListNode addnode){
        DeListNode deListNode;
        if(freqMap.containsKey(freq)){
            deListNode=freqMap.get(freq);
        }
        else{
            deListNode=new DeListNode();
        }
        deListNode.addHeadNode(addnode);
        freqMap.put(freq,deListNode);
    }
public ListNode removeNode(int key){
        ListNode deleteNode=map.get(key);
        ListNode preNode=deleteNode.pre;
        ListNode nextNode=deleteNode.next;
        preNode.next=nextNode;
        nextNode.pre=preNode;
        deleteNode.pre=null;
        deleteNode.next=null;
        freqMap.get(deleteNode.freq).count--;
        deleteNode.freq++;
        maxFrequent=Math.max(deleteNode.freq,maxFrequent);
        return deleteNode;
    }
}

/**
 *  * Your LFUCache object will be instantiated and called as such:
 *   * LFUCache obj = new LFUCache(capacity);
 *    * int param_1 = obj.get(key);
 *     * obj.put(key,value);
 *      */
