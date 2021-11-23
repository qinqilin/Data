package BinaryTree;
//sdD
//二叉树

public class BinaryTree<Key extends Comparable<Key>,Value> {

    private Node root;//根节点
    private int N;//记录元素个数

    //结点类
    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        //结点构造方法
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //初始化二叉树
    public BinaryTree() {
        this.root=null;
        this.N=0;
    }

    //向树中插入一个键值对
    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    //给指定树x上，添加一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value){
        //如果x子树为空
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果x子树不为空
        //如果新结点的key大于当前结点的key，继续找当前结点的右子结点
        int cmp= key.compareTo(x.key);
        if(cmp>0){
            x.right=put(x.right,key,value);
        }else if(cmp<0){//如果新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left=put(x.left,key,value);
        }else {//如果新结点的key等于当前结点的key，把当前结点的value进行替换
            x.value=value;
        }
        return x;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key){
        return get(root,key);
    }

    //从指定的树x中，找出key对应的值
    private Value get(Node x, Key key){
        //x数为空
        if(x==null){
            return null;
        }
        //x数不为空
        int cmp= key.compareTo(x.key);
        if(cmp>0){
            return get(x.right,key);
        }else if(cmp<0){
            return get(x.left,key);
        }else {
            return x.value;
        }


    }

    //根据key，删除树中对应的键值对
    public void delete(Key key){
        delete(root,key);
    }

    //删除指定树x上的键为key的键值对，并返回删除后的新树
    private Node delete(Node x, Key key){
        //x为空
        if(x==null){
            return null;
        }
        //x不为空
        int cmp= key.compareTo(x.key);
        if(cmp>0){//如果新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right=delete(x.right,key);
        }else if(cmp<0){//如果新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left=delete(x.left,key);
        }else {//如果新结点的key等于x结点的key，完成真正的删除结点动作，要删除的结点就是x
            N--;
            //得到右子树中最小结点
            if(x.right==null){
                return x.left;
            }
            if(x.left==null){
                return x.right;
            }
            Node minNode=x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            //删除右子树中最小结点
            Node n=x.right;
            while (n.left!=null){
                if(n.left.left==null){//如果当前结点的下一个结点的下一个结点为空，那么就让当前结点指向空
                    n.left=null;
                }else {
                    n=n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right=x.right;
            //让x结点的父节点指向minNode
            x=minNode;

        }
        return x;

    }

    //获取树中元素的个数
    public int size(){
        return N;
    }

}
