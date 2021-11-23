package Linear.Sequence;

public class VariableCapacityTest {
    public static void main(String[] args) {

        SequenceList<String> s=new SequenceList<>(3);
        s.insert("张三");
        s.insert("李四");
        s.insert("王五");
        s.insert("xiaoohong");
        for(String i : s){
            System.out.print(i);
        }

    }





}
