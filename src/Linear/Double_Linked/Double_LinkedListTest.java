package Linear.Double_Linked;


public class Double_LinkedListTest {
    public static void main(String[] args) {

        //创建链表对象
        Double_LinkedList<String> list=new Double_LinkedList<>();
        //插入
        list.insert("ab");
        list.insert("bc");
        list.insert("cd");
        list.insert("de");
        for (String i: list) {
            System.out.print(i);
        }
        System.out.println("\n");
        //删除
        System.out.println("移除第1个元素"+list.remove(1));
        for (String i: list) {
            System.out.print(i);
        }
        System.out.println("\n");
        //获取
        String str=list.get(2);
        System.out.println("第2个元素"+str);
        System.out.println("++++++++++++++++++++++++++");
        //获取第一个元素
        System.out.println("第一个元素："+list.getFirst());
        //获取最后一个元素
        System.out.println("最后一个元素："+list.getLast());
        //清空
        list.clear();
        System.out.println(list.length());
    }
}
