package Linear.Single_Linked;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<T> {
    //记录头结点
    private Node head;
    //记录链表长度
    private int N;

    //结点类
    private class Node {
        T item;//存储数据
        Node next;//下一个结点
        //构造方法
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkedList(){
        //初始化头结点
        this.head=new Node(null,null);
        this.N=0;
    }

    //清空链表
    public void clear(){
        head.next=null;
        this.N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return this.N==0;
    }

    //获取指定位置i处的元素
    public T get(int i){
        //通过循环，从头结点开始往后找，依次找i次
        Node n=head.next;
        for(int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }

    //向链表中添加元素
    public void insert(T t){
        //找到最后一个节点
        Node n=head;
        while (n.next!=null){
            n=n.next;
        }
        //创建新节点
        Node newNode=new Node(t,null);
        //让当前最后一个节点指向新节点
        n.next=newNode;
        //元素个数+1
        N++;
    }

    //在位置i处添加元素t
    public void insert(int i,T t){
        //找到i位置的前一个结点
        Node pre=head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr=pre.next;
        //创建新节点，并且指向原来i位置的结点
        Node newNode=new Node(t,curr);
        //原来i位置的前一个结点指向新节点
        pre.next=newNode;
        //元素个数+1
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i){
        //找到i位置的前一个结点
        Node pre=head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr=pre.next;
        //找到i位置的下一个结点
        Node nextNode=curr.next;
        //前一个结点指向下一个结点
        pre.next=nextNode;
        //元素个数-1
        N++;
        return curr.item;
    }

    //查找t元素第一次出现的索引
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

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;

        public LIterator() {
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

    //反转整个链表
    public void reverse(){

        if(isEmpty()){
            //如果是空链表,直接结束
            return;
        }
        reverse(head.next);

    }

    //反转指定结点curr,并将反转后的curr结点返回
    public Node reverse(Node curr){
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归的反转当前结点curr的下一个结点；返回值就是链表反转后，当前结点的上一个节点
        Node pre=reverse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }

    public void relist(){
        if(isEmpty()){
            return;
        }
        Node newNode=new Node(null,null);
        Node curr=head.next;
        Node next=null;
        while (curr!=null){
            next=curr.next;
            curr.next=newNode.next;
            newNode.next=curr;
            curr=next;
        }
        head.next=newNode.next;

    }






}
