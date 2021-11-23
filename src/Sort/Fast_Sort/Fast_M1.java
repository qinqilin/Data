package Sort.Fast_Sort;

public class Fast_M1 {

    //比较a和b的大小
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    //排序
    public static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    //排序
    private static void sort(Comparable[] a,int lo,int hi){
       //安全校验
        if(lo>hi){
            return;
        }
        //需要对lo到hi索引的元素进行分组（左子组合右子组）
        int partition=partition(a, lo, hi);//分界值位置变换后的索引
        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    //对索引lo到hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int lo,int hi){
        //确定分界值，默认是数组a中的第一个
        Comparable key=a[lo];
        //定义两个指针
        int left=lo;
        int right=hi+1;
        //切分
        while (true){

            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key,a[--right])){
                if(right==lo){
                    break;
                }
            }

            //先从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if(left==hi){
                    break;
                }
            }

            //判断left>=right，如果是，证明元素扫描完毕，结束循环，如果不是，那么交换元素
            if(left>=right){
                break;
            }else {
                exCh(a,left,right);
            }
        }
        //交换分界值
        exCh(a,lo,right);
        return right;
    }

    //交换元素i和j的位置
    public static void exCh(Comparable[] c,int i,int j){
        Comparable temp;
        temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }

}
