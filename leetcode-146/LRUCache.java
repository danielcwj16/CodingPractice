/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?
 */


/**
 * 用double linked list以及hashmap实现LRU cache经典题。注意sethead以及removenode的方法实现以及next及pre指针的位置
 */
import java.util.*;
public class LRUCache{
    int capacity;
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node head=null;
    Node tail = null;

    public class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.val = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        else{
            Node nd = map.get(key);
            remove(nd);
            setHead(nd);
            return nd.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nd = map.get(key);
            nd.val = value;
            remove(nd);
            setHead(nd);
        }else{
            Node newnode = new Node(key,value);
            if(map.size()>=capacity){
                map.remove(tail.key);
                remove(tail);             
                setHead(newnode);
            }else{
                setHead(newnode);
            }
            map.put(key,newnode);
        }
    } 
    public void remove(Node nd){
        if(nd.pre != null){
            nd.pre.next = nd.next;
        }else{
            head = nd.next;
        }
        if(nd.next != null){
            nd.next.pre = nd.pre;
        }else{  
            tail = nd.pre;
        }
    }
    

    public void setHead(Node nd){
        nd.next = head;
        nd.pre = null;

        if(head != null){
            head.pre = nd;
        }
        head = nd;
        if(tail == null){
            tail = head;
        }
    }
    
    
}

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node head=null;
    Node end=null;
    
  
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node n = map.get(key);
        removeNode(n);
        setHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            n.val = value;
            removeNode(n);
            setHead(n);
        }
        else
        {
            Node m = new Node(key,value);
            if(capacity == map.size())
            {
               
                map.remove(end.key);
                setHead(m);
                removeNode(end);
            }
            else
            {
                
                setHead(m);
            }
            map.put(key,m);
        }
    }
    
    private void removeNode(Node n)
    {
       if(n.pre != null)
        {
            n.pre.next = n.next;
        }
        else
            head = n.next;
        
        if(n.next != null)
            n.next.pre = n.pre;
        else
            end = n.pre;
    }
    
    private void setHead(Node n)
    {
        n.next = head;
        n.pre = null;
        
        if(head!=null)
            head.pre = n;
        
        head = n;
        
        if(end == null)
            end = head;
    }
}

class Node
{
    int key;
    int val;
    Node next;
    Node pre;
    
    public Node(int key,int value)
    {
        this.key = key;
        this.val = value;
    }
    
}

1,1    1,1
2,2->1.1   1,1  2,2

1,1->2,2    1,1  2,2

3,3 -> 1,1   1,1 3,3

["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]