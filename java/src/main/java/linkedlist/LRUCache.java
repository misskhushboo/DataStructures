package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Data stored in key value form.
 * Least recently used cache: two main functions:
 * get(key) - get key and also will come at top.
 * put(key) - If data is added, added on top. Remove least recent to make space for new items if size limit is hit.
 * Operations are performed in O(1).
 * Doubly Linked List - to maintain data order. LRU data will at the end of DLL, New data will be put at start of DLL.
 * HashMap for data retrieval.
 * https://www.youtube.com/watch?v=LZgDpjCIHm0
 */
public class LRUCache {


    int capacity=0;
    Map<Integer, DoubleNode> map;
    DoubleNode head, tail;

    public static void main(String[] args){
        LRUCache cache=new LRUCache(2);
        cache.get(2);
        System.out.println("Get called");

    }

    public LRUCache(int capacity) {
        //create doubly linked list
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
        //initiate capacity
        this.capacity = capacity;
        //initiate map
        map=new HashMap<Integer, DoubleNode>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
          DoubleNode presentNode = map.get(key);
          int value = presentNode.value;
          // remove from the list so we can add it again to the head
          remove(map.get(key));

          DoubleNode newNode = new DoubleNode(key, value);
          addToFront(key, value, newNode);
          return value;
        }
        else
           return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoubleNode presentNode=map.get(key);
        }
        DoubleNode newNode = new DoubleNode(key, value);

        if(map.size()==capacity){
            DoubleNode node=tail.prev;
            map.remove(node.key);
            remove(node);
        }
        map.put(key,newNode);
        addToFront(key, value, newNode);
    }

    public void remove(DoubleNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToFront(int  key, int value,DoubleNode newNode) {

        head.prev=newNode;
        newNode.next = head;
    }
}
