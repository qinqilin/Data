package Sort.Bubble_Sort;

public class Bubble_M1 {
    public static void main(String[] args) {
        int[] num={5,8,6,7,2,3,4,9,1};
        BubbleSport(num);
    }

    private static void BubbleSport(int[] num) {

        int temp=0;
        for(int i=1;i< num.length;i++){
            for(int j=0;j< num.length-i;j++){
                if(num[j]>num[j+1]){
                    temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }

        for (int i : num) {
            System.out.print(i);
        }
    }







}
