package Sort.Merge_Sort;



public class MergeTest_M1 {

    public static void main(String[] args) {

        Integer[] num={8,4,5,7,1,3,6,2};
        Merge_M1.sort(num);
        for(Comparable i:num){
            System.out.print(i);
        }
    }
}
