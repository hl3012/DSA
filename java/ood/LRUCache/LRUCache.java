package LRUCache;

import java.util.*;

//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// get:
// 如果 key 存在，返回 value
// 并把该 key 标记为“最近使用”
// put:
//如果 key 已存在，更新 value，并标记为最近使用
// 如果容量满了，删除“最久未使用”的元素

// 面试隐藏考点
// get 和 put 必须 O(1)
// 你必须主动说：HashMap + Doubly LinkedList
// 需要 dummy head/tail
// 需要处理：
// 容量=0
// 更新已有key

// Follow-up 可能问
// 如何线程安全？
// 如果容量非常大怎么办？
// 如何支持 TTL？

class LRUNode {
    int key;
    int val;
    LRUNode next;
    LRUNode pre;
    LRUNode(int key, int val) {
        this.key=key;
        this.val = val;
        this.next=null;
        this.pre=null;
    }
}

public class LRUCache {
    int capacity;
    LRUNode head;
    LRUNode tail;
    Map<Integer, LRUNode> map;
    LRUCache(int capacity) {
        if(capacity<1) throw new IllegalArgumentException();
        this.capacity=capacity; //capacity>=1
        map=new HashMap<>();
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next=tail;
        tail.pre= head;
    }

    int get(int key)  { //if there is key, return value, or return -1 O(1)  mark as recently used
        if(!map.containsKey(key)) return -1;
        LRUNode node = map.get(key);
        remove(node); //remove node from linkedList
        addLast(node); //add to the tail pre
        return node.val;
    } 

    boolean put(int key, int value){
        //include  update value, addLast
        if(map.containsKey(key)) {
            LRUNode node =map.get(key);
            remove(node);
            node.val=value;
            addLast(node);
            map.put(key, node);
            return true;
        } 
        if(map.size()==capacity) {
            LRUNode first =removeFirst();
            map.remove(first.key);
        }
        LRUNode newNode = new LRUNode(key, value);
        addLast(newNode);
        map.put(key, newNode);
        return true;

    } //remove least recently used key O(1)   if key exist update value,mark as rcently used; key not exist, capacity ==;remove key then inert

    private void remove(LRUNode node) {
        LRUNode pre = node.pre;
        LRUNode next = node.next;
        pre.next=next;
        next.pre = pre;
    }

    private void addLast(LRUNode node) {
        LRUNode pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next =tail;
        tail.pre = node;
    }
    
    private LRUNode removeFirst() {
        LRUNode first = head.next;
        remove(first);
        return first;
    }
}
