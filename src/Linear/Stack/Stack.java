package Linear.Stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //初始化构造方法
    public Stack() {
        this.head=new Node(null,null);
        this.N=0;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //栈中元素个数
    public int size(){
        return N;
    }

    //弹出栈顶元素
    public T pop(){

        Node oldFirst=head.next;//找到第一个结点
        if(oldFirst==null){
            return null;
        }
        head.next=oldFirst.next;//让头结点指向第一个结点的下一个结点
        N--;//
        return oldFirst.item;


    }

    //向栈中压入元素
    public void push(T t){
        Node oldFirst=head.next;//找到第一个结点
        Node newNode=new Node(t,null);//创建新节点
        head.next=newNode;//让头结点指向新节点
        newNode.next=oldFirst;//让新节点指向以前的头结点
        N++;//元素个数加一

    }

    @Override
    public Iterator<T> iterator() {
        return new sIterator();
    }

    public  class sIterator implements Iterator{

        private Node n;

        public sIterator() {
            this.n =head;
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
