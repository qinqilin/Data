package Heap;

public class Heap<T extends Comparable<T>>{

    private T[] items;
    private int N;

    public Heap(int capacity) {
        this.items=(T[]) new Comparable[capacity+1];
        this.N=0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中i索引和j索引处的值
    private void exCh(int i,int j){
        T temp=items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    //删除堆中最大的元素,并返回这个最大元素
    public T delMax(){
        T max=items[1];
        //交换索引1处和最大索引的值，将最大索引的值作为临时根节点
        exCh(1,N);
        //删除最大索引处的结点
        items[N]=null;
        //元素个数-1
        N--;
        //元素下沉，让根节点找到合适的位置
        sink(1);
        return max;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N]=t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k>1){
            if(less(k/2,k)){
                exCh(k/2,k);
            }
            k=k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        while (2*k<=N){
            //找到子结点的最大结点
            int max;
            if(2*k+1<=N){//存在右结点
                if(less(2*k,2*k+1)){
                    max=2*k+1;
                }else {//不存在右结点
                    max=2*k;
                }
            }else {//
                max=2*k;
            }
            if(!less(k,max)){
                break;
            }
            exCh(k,max);//如果索引K处的值小于索引max处的值，则交换
            k=max;//将索引替换为k的子结点的最大值，实现元素下沉
        }
    }



}
