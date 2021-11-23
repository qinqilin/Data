package Sort.Insert_Sort;

public class Insert_M2 {

    //排序
    public static void sort(Comparable[] a){

        for(int i=1;i< a.length;i++){
            for (int j=i-1;j>=0;j--){
                if(greater(a[j],a[i])){
                    exCh(a,i,j);
                    i--;
                }
            }
        }
        for(Comparable i:a){
            System.out.print(i);
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
