package SymbolTable;

public class SymbolTable<Key,Value> {

    //记录首结点
    private Node head;
    //元素个数
    private int N;
    //结点类
    public class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //符号表的初始化
    public SymbolTable() {
        this.head=new Node(null,null,null);
        this.N=0;

    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //向符号表插入键值对
    public void put(Key key,Value value){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        Node newNode=new Node(key,value,null);
        Node oldFirst=head.next;
        head.next=newNode;
        newNode.next=oldFirst;
        N++;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        Node n=head;
        int index=0;
        while (n.next!=null) {
            //判断n的下一个结点的key是否为key
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }

    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }

    //是否为空
    public boolean isEmpty(){
        return N==0;
    }


}
