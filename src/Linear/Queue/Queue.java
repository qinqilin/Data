package Linear.Queue;
//队列
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
        private Node head;
        private Node last;
        private int N;

        private class Node{
            public T item;
            public Node next;
            //结点的构造方法
            public Node(T item, Node next) {
                this.item = item;
                this.next = next;
            }
        }
    //队列的初始化
    public Queue() {
         this.N=0;
         this.head=new Node(null,null);
         this.last=null;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //从队列中拿出一个元素
    public T dequeue(){
        Node firstNode=head.next;
        if (isEmpty()){
            return null;
        }
        head.next=firstNode.next;
        N--;
        if(isEmpty()){
            last=null;
        }
        return firstNode.item;

    }

    //往队列中插入一个元素
    public void enqueue(T t){
        /*Node n=head;
        while (n.next!=null){
            n=n.next;
        }
        Node newNode=new Node(t,null);
        n.next=newNode;
        newNode.next=null;
        N++;*/
        if(last==null){
            last=new Node(t,null);
            head.next=last;
        }else{
            Node oldLast=last;
            last=new Node(t,null);
            oldLast.next=last;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {

        return new QIterator();
    }
    public class QIterator implements Iterator{

        private Node n;

        public QIterator() {
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
