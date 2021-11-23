package Sort.Shell_Sort;

public class Shell_M1 {
    public static void main(String[] args) {
        int[] num={9,1,2,5,7,4,8,6,3,5};
        Shell(num);
    }

    private static void Shell(int[] num) {

        int h=1;
        while (h< num.length/2){
            h=2*h+1;
        }

        while (h>=1){
            //排序
            for(int i=h;i< num.length;i++){
                for(int j=i;j>=h;j-=h){
                    if (num[j - h] > num[j]) {
                        int temp=num[j-h];
                        num[j-h]=num[j];
                        num[j]=temp;
                    }else {
                        break;
                    }
                }
            }
            h/=2;//减小h的值
        }
        for(int i: num){
            System.out.print(i);
        }


    }
}
