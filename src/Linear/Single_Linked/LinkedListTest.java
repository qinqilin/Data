package Linear.Single_Linked;

public class LinkedListTest {
    public static void main(String[] args) {

        //创建链表对象
        LinkedList<String> list=new LinkedList<>();
        //插入
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
        for (String i: list) {
            System.out.println(i);
        }

        /*//获取
        String str=list.get(2);
        System.out.println(str);*/
        /*//删除
        list.remove(3);
        //清空
        list.clear();
        System.out.println(list.length());*/
        System.out.println("--------------------");
        //链表反转
        list.reverse();
        for (String i: list) {
            System.out.println(i);
        }

        System.out.println("--------------------");


        list.relist();
        for (String i: list) {
            System.out.println(i);
        }

    }
}
