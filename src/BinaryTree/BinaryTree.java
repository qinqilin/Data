package BinaryTree;
//sdD
//二叉树

import Linear.Queue.Queue;

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

    //找出树中最小的键
    public Key min(){
        return min(root).key;
    }
    //找出指定树x中，最小键所在的结点
    private Node min(Node x){
        if(x==null){
            return null;
        }
        if(x.left!=null){
            return min(x.left);
        }else {
            return x;
        }

    }

    //找出树中最小的键
    public Key max(){
        return max(root).key;
    }
    //找出指定树x中，最小键所在的结点
    private Node max(Node x){
        if(x==null){
            return null;
        }
        if(x.right!=null){
            return min(x.right);
        }else {
            return x;
        }
    }

/*
* ++++++++++++++++++++前序遍历++++++++++++++++++++++++++
* */
    //使用前序遍历，获取整个树中的所有键
    public Queue<Key> preErgodic(){
        Queue<Key> keys=new Queue<>();
        preErgodic(root,keys);
        return keys;
    }
    //使用前序遍历，把指定树x中的所有键放入到keys队列中
    private void preErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        //把x结点的key放入keys中
        keys.enqueue(x.key);
        //找到当前结点的左子树，如果不为空，递归遍历左子树
        if(x.left!=null){
            preErgodic(x.left,keys);
        }
        //找到当前结点的右子树，如果不为空，递归遍历右子树
        if(x.right!=null){
            preErgodic(x.right,keys);
        }
    }

/*
 * ++++++++++++++++++++中序遍历++++++++++++++++++++++++++
 * */
    //使用中序遍历，获取整个树中的所有键
    public Queue<Key> midErgodic(){
        Queue<Key> keys=new Queue<>();
        midErgodic(root,keys);
        return keys;
    }
    //使用中序遍历，把指定树x中的所有键放入到keys队列中
    private void midErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        //找到当前结点的左子树，如果不为空，递归遍历左子树
         if (x.left!=null){
             midErgodic(x.left,keys);
         }
        //把x结点的key放入keys中
        keys.enqueue(x.key);
        //找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right!=null){
            midErgodic(x.right,keys);
        }
    }

/*
 * ++++++++++++++++++++后序遍历++++++++++++++++++++++++++
 * */
    //使用后序遍历，获取整个树中的所有键
    public Queue<Key> afterErgodic(){
        Queue<Key> keys=new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }
    //使用后序遍历，把指定树x中的所有键放入到keys队列中
    private void afterErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        //找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        //找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        //把x结点的key放入keys中
        keys.enqueue(x.key);
    }

/*
 * ++++++++++++++++++++层序遍历++++++++++++++++++++++++++
 * */
    public Queue<Key> layerErgodic(){
        Queue<Key> keys=new Queue<>();
        Queue<Node> nodes=new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //弹出nodes队列的元素
            Node n=nodes.dequeue();
            keys.enqueue(n.key);
            //判断左节点是否存在
            if(n.left!=null){
                nodes.enqueue(n.left);
            }
            //判断右节点是否存在
            if(n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    //计算整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    //计算指定树x的最大深度
    private int maxDepth(Node x){
        if(x==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        //计算左子树的最大深度
        if(x.left!=null){
            maxL=maxDepth(x.left);
        }
        //计算右子树的最大深度
        if(x.right!=null){
            maxR=maxDepth(x.right);
        }
        //当前树的最大深度=左子树的最大深度和右子树的最大深度中的较大者+1
        max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }

}
