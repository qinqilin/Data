package Sort.Select_Sort;

//选择排序
public class Select_M2 {


    public  static void sort(Comparable[] a){
        for(int i=0;i< a.length-1;i++){
            int min=i;
            for(int j=i+1;j< a.length;j++){
                if(greater(a[min],a[j])){
                    min=j;
                }
            }
            exCh(a,i,min);
        }
        for(Comparable k:a){
            System.out.print(k);
        }


    }

    private static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;

    }

    private static void exCh(Comparable[] c,int i,int j){
        Comparable temp;
        temp =c[i];
        c[i]=c[j];
        c[j]=temp;

    }
}
