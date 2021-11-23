package Sort.Bubble_Sort;

public class Bubble_M2 {

    //排序
    public static void sort(Comparable[] a){
       for(int i=1;i< a.length;i++){
           for(int j=0;j< a.length-i;j++){
               if(greater(a[j],a[j+1])){
                   exCh(a,j,j+1);
               }
           }
       }
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
