package Heap;

public class HeapSort {

    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exCh(Comparable[] heap, int i, int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    //根据原数组source，构造出堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //将原数组source拷贝到heap
        System.arraycopy(source,0,heap,1,source.length);
        for(int i=(heap.length)/2;i>0;i--){
            sink(heap,i, heap.length-1);
        }
    }

    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap=new Comparable[source.length+1];
        createHeap(source,heap);
        //定义变量记录索引最大值
        int N= heap.length-1;
        //通过循环交换索引1处的元素和索引最大值得元素，并下沉
        while (N!=1){
            exCh(heap,1,N);
            N--;//将最大索引处的值排除
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,heap.length-1);

    }

    //在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range){

        while (2*target<=range){
            //找出当前结点较大的子节点
            int max;
            if(2*target+1<= range){
                if(less(heap,2*target+1,2*target)){
                    max=2*target;
                }else {
                    max=2*target+1;
                }
            }else {
                max=2*target;
            }
            //比较当前结点的值和较大子节点的值
           if(!(heap[target].compareTo(heap[max])<0)){
               break;
           }
            exCh(heap,target,max);
           target=max;

        }

    }

}
