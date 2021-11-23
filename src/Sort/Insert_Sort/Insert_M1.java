package Sort.Insert_Sort;

public class Insert_M1 {
    public static void main(String[] args) {

        int[] num={4,3,2,10,12,9,1,5,16};
        InsertSort(num);
    }

    private static void InsertSort(int[] num) {
        int temp;
        for(int i=1;i< num.length;i++){
            for (int j=i-1;j>=0;j--){
                if(num[i]<num[j]){
                    temp=num[j];
                    num[j]=num[i];
                    num[i]=temp;
                    i--;
                }
            }
        }

        for(int i:num){
            System.out.print(i);
        }
    }

}
