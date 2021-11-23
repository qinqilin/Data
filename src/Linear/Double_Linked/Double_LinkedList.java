package Linear.Double_Linked;

import java.util.Iterator;

public class Double_LinkedList<T> implements Iterable<T>{

    private Node head;
    private Node last;
    private int N;



    private class Node {
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    //创建链表初始化
    public Double_LinkedList() {
       this.head=new Node(null,null,null);
       this.last=null;
       this.N=0;
    }

    //清空链表
    public void clear(){
        this.head.next=null;
        this.head.pre=null;
        this.head.item=null;
        this.last=null;
        this.N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        Node n=this.head.next;
        return n.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素
    public void insert(T t){
        //如果为空
        if(isEmpty()){
            //头结点指向尾结点
            //创建新节点
            Node newNode=new Node(t,head,null);
            //让新节点成为尾结点
            last=newNode;
            //让头结点指向尾结点
            head.next=last;
        }else {
            //如果不为空
            //创建新节点
            Node oldLast=last;
            Node newNode=new Node(t,oldLast,null);
            //当前尾结点指向新节点
            oldLast.next=newNode;
            //让新节点成为尾结点
            last=newNode;
        }
        N++;//元素个数+1
    }

    //在指定位置i处插入元素
    public void insert(int i,T t){
        //找到i的前一个元素
        Node pre=head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到第i个元素
        Node curr=pre.next;
        //创建新节点
        Node newNode=new Node(t,pre,curr);
        //让i位置的前一个结点的下一个结点变成新节点
        pre.next=newNode;
        //让i位置的前一个结点变为新节点
        curr.pre=newNode;
        //元素+1
        N++;
    }

    //获取指定位置i处的元素
    public T get(int i){
        Node n=head.next;
        for(int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }

    //查找元素t在链表第一次出现的位置
    public int indexOf(T t){
        Node n=head;
        for(int i=0;n.next!=null;i++){
            n=n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    //删除位置i处的元素
    public T remove(int i){
        Node pre=head;
        //寻找i前一个位置结点
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //当前i位置的结点
        Node curr=pre.next;
        //位置i后一个结点
        Node nextNode=curr.next;
        //位置i的前一个结点指向i后一个结点
        pre.next=nextNode;
        //位置i的后一个结点指向i的前一个结点
        nextNode.pre=pre;
        //元素个数-1
        N--;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new dIterator();
    }

    private class dIterator implements Iterator{
        private Node n;

        public dIterator() {
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

}
