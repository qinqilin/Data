package Linear.Sequence;

public class SequenceTest {
    public static void main(String[] args) {

        //创建顺序表对象
        SequenceList<String> list=new SequenceList<>(10);
        //插入
        list.insert("ab");
        list.insert("bc");
        list.insert("cd");
        list.insert("de");
        for (String i: list) {
            System.out.println(i);
        }

        //获取
        String str=list.get(2);
        System.out.println(str);
        //删除
        list.remove(3);
        //清空
        list.clear();
        System.out.println(list.length());
    }
}
