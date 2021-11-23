package Sort.Shell_Sort;

public class Shell_M2 {

    //排序
    public static void sort(Comparable[] a){
        int h=1;
        while (h< a.length/2){
            h=2*h+1;
        }

        while (h>=1){
            //排序
            for(int i=h;i< a.length;i++){
                for(int j=i;j>=h;j-=h){
                    if (greater(a[j-h],a[j])) {
                       exCh(a,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            h/=2;//减小h的值
        }
        /*for(Comparable i: a){
            System.out.print(i);
        }*/
    }

    //比较a和b的大小
    public static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }

    //交换元素i和j的位置
    public static void exCh(Comparable[] c,int i,int j){
        Comparable temp;
        temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
