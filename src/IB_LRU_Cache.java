import java.util.*;
public class IB_LRU_Cache {
    public static void main(String args[]){

    }

    public static class Solution {
        public class Node{
            int Key;
            Node Next;
            Node Prev;
        }
        public Node Head;
        public Node Tail;
        public HashMap<Integer,Integer> Data;
        public HashMap<Integer,Node> KeyToNode;
        public int Count;
        public int Capacity;
        public Solution(int capacity) {
            this.Capacity=capacity;
            this.Data = new HashMap<Integer,Integer>();
            this.KeyToNode = new HashMap<Integer,Node>();
        }

        public int get(int key) {
            if(!this.Data.containsKey(key)){
                return -1;
            }
            int val = this.Data.get(key);
            if(this.Capacity==1){
                return val;
            }
            Node temp = this.KeyToNode.get(key);
            if(this.Tail==temp){

                return val;
            }
            if(this.Head==temp){
                this.Head = this.Head.Next;
                this.Tail.Next = temp;
                temp.Prev = this.Tail;
                this.Tail = temp;
            }else{
                temp.Prev.Next = temp.Next;
                temp.Next.Prev = temp.Prev;
                this.Tail.Next = temp;
                temp.Prev = this.Tail;
                this.Tail = temp;
            }
            return val;







        }

        public void set(int key, int value) {
            if(this.Data.containsKey(key)){
                this.Data.put(key,value);
                Node y = this.KeyToNode.get(key);
                if(this.Tail==y){
                    return;
                }
                if(this.Count==1){
                    return ;
                }
                if(this.Count == 2){

                    Node z = this.Tail;
                    z.Next = y;
                    y.Prev = z;
                    this.Head = z;
                    this.Tail = y;
                    return;
                }

                if (this.Head ==y){
                    this.Head = this.Head.Next;
                    this.Tail.Next = y;
                    y.Prev=this.Tail;
                    this.Tail = y;
                    return;


                }
                y.Prev.Next = y.Next;
                y.Next.Prev = y.Prev;
                this.Tail.Next = y;
                y.Prev = this.Tail;
                this.Tail = y;
                return;



            }

            Node x = new Node();
            this.Data.put(key,value);
            x.Key = key;
            this.Count = this.Count + 1;
            if(this.Count == 1){

                this.Head = x;

                this.Tail = x;

                this.KeyToNode.put(key,this.Tail);
                return ;
            }


            if(this.Count > this.Capacity){

                this.Count = this.Capacity;
                if(this.Capacity == 1){

                  int l= this.Head.Key;
                    this.Data.remove(l);

                    this.Head = x;
                    this.Tail = x;
                    this.KeyToNode.put(key,this.Tail);
                    return;
                }
                Node temp = this.Head;
                this.Head = this.Head.Next;
                //c.Head.Prev = nil
                this.Data.remove(temp.Key);


            }
            this.Tail.Next = x;
            x.Prev = this.Tail;
            this.Tail = x;
            this.KeyToNode.put(key,this.Tail);



        }
    }

}
