package LRUCache;

import java.util.*;

// 规则：
// 如果容量满了，淘汰 访问频率最低 的 key
// 如果有多个频率相同的 key，淘汰 最久未使用的那个（同频率内 LRU）
// get 和 put 平均时间复杂度 O(1)



class LFUNode {
    int key;
    int val;
    int freq;
    LFUNode next;
    LFUNode pre;

    LFUNode(int key, int val) {
        this.key=key;
        this.val = val;
        next=null;
        pre=null;
        this.freq=1;
    }
}

class LFUList {
    LFUNode head;
    LFUNode tail;
    int size;

    LFUList() {
        this.head=new LFUNode(-1, -1);
        this.tail=new LFUNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        size=0;
    }

    public void remove(LFUNode node) {
        LFUNode pre = node.pre;
        LFUNode next = node.next;
        pre.next=next;
        next.pre = pre;
        size--;
    }

    public void addLast(LFUNode node) {
        LFUNode pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next =tail;
        tail.pre = node;
        size++;
    }
    
    public LFUNode removeFirst() {
        LFUNode first = head.next;
        remove(first);
        return first;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class LFUCache {
    int capacity;
    Map<Integer, LFUNode> map;
    Map<Integer, LFUList> freq;
    int minFreq;
    LFUCache(int capacity) {
        if(capacity<1) throw new IllegalArgumentException();
        this.capacity=capacity; //capacity>=1
        map=new HashMap<>();
        freq=new HashMap<>();    
        minFreq=0;  
    }

    int get(int key)  { //if there is key, return value, or return -1 O(1)  mark as recently used
        if(!map.containsKey(key)) return -1;
        LFUNode node = map.get(key);
        touch(node);  //freq.remove key,list;add new freq, keylist
        return node.val;
    } 

    boolean put(int key, int value){
        //include  update value, addLast
        if(map.containsKey(key)) {
            LFUNode node =map.get(key);
            node.val=value;
            touch(node);
            return true;
        } 
        if(map.size()==capacity) {
            LFUList list = freq.get(minFreq);
            LFUNode first =list.removeFirst();
            map.remove(first.key);
        }
        LFUNode newNode = new LFUNode(key, value);
        map.put(key, newNode);
        freq.computeIfAbsent(1, f->new LFUList()).addLast(newNode);
        minFreq=1;
        return true;

    } //remove least recently used key O(1)   if key exist update value,mark as rcently used; key not exist, capacity ==;remove key then inert

    private void touch(LFUNode node) {
        int oldFreq = node.freq;
        LFUList list=freq.get(oldFreq);
        list.remove(node);

        if(minFreq==oldFreq&&list.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freq.computeIfAbsent(node.freq,f->new LFUList()).addLast(node);

    }

    
}
