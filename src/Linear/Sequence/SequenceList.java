package Linear.Sequence;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    //存储元素的数组
    private T[] eles;
    //记录当前元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }

    //将一个线性表置空
    public void clear(){
        this.N=0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return this.N == 0;
    }

    //获取线性表的长度
    public int length(){
        return this.N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线性表中添加元素
    public void insert(T t){
        if(N==eles.length){
            resize(2*eles.length);
        }
        eles[N++]=t;
    }

    //向i元素处插入元素t
    public void insert(int i,T t){
        //将i后面的元素后移一位
        for(int j=N;j>i;j--){
            eles[j]=eles[j-1];
        }
        eles[i]=t;
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i){
        T obj=eles[i];
        for(int j=i;j<N-1;j++){
            eles[j]=eles[j+1];
        }
        N--;
        if(N<=eles.length/4){
            resize(eles.length/2);
        }
        return obj;
    }

    //查找t元素第一次出现的索引
    public int indexOf(T t){
        for(int i=0;i<N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;//没找到就返回-1
    }

    //根据参数newSize重置eles的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp=eles;
        eles=(T[])new Object[newSize];
        for(int i=0;i<N;i++){
            eles[i]=temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new sIterator();
    }

    private class sIterator implements Iterator{

        private int cusor;

        public sIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

}
