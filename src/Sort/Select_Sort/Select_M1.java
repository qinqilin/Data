package Sort.Select_Sort;

//选择排序
public class Select_M1 {
    public static void main(String[] args) {
        int[] num={5,8,6,7,2,2,4,3,9,11,1,1};
        Select(num);
    }

    private static void Select(int[] num) {
        int temp=0;
        int min;
        int index=0;
        for(int i=0;i< num.length-2;i++){
            min=num[i];
            for(int j=i+1;j< num.length;j++){
                if(min>num[j]){
                    min=num[j];
                    index=j;
                }
            }
            temp =num[i];
            num[i]=num[index];
            num[index]=temp;

            for (int k: num){
                System.out.print(k);
            }
            System.out.println();
        }
        /*for (int i: num){
            System.out.print(i);
        }*/
    }


}
