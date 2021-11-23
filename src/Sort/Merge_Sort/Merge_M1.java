package Sort.Merge_Sort;


public class Merge_M1 {

    public static Comparable[] assist;

    //排序
    public static void sort(Comparable[] a){

        assist =new Comparable[a.length];
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    //比较a和b的大小
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a,int lo,int hi){
        //安全校验
        if(hi<=lo){
            return;
        }
        //对lo到hi之间的数据进行分为两个组
        int mid=(lo+hi)/2;
        //分别对每一组数据排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //合并
        merge(a,lo,mid,hi);

    }

    //从索引lo到所以mid为一个子组，从索引mid+1到索引hi为另一个子组，把数组a中的这两个子组的数据合并成一个有序的大组（从
    //索引lo到索引hi）
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针
        int i=lo;
        int p1=lo;
        int p2=mid+1;

        //遍历，移动p1和p2指针，比较对应索引的值，放到辅助数组对应的索引处
        while (p1<=mid&&p2<=hi){
            //比较对应索引的值
            if(less(a[p1],a[p2])){
                assist[i]=a[p1];
                i++;p1++;
            }else {
                assist[i]=a[p2];
                i++;p2++;
            }
        }

        //遍历，如果p1指针没走完，那么顺序移动p1指针，把对应元素放到辅助数组对应的索引处
        while (p1<=mid){
            assist[i++]=a[p1++];
        }

        //遍历，如果p2指针没走完，那么顺序移动p2指针，把对应元素放到辅助数组对应的索引处
        while (p2<=hi){
            assist[i++]=a[p2++];
        }

        //把辅助数组中的元素拷贝到原始数组值
        for(int index=lo;index<=hi;index++){
            a[index]=assist[index];
        }

    }



}
