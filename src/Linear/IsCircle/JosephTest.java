package Linear.IsCircle;

public class JosephTest {
    public static void main(String[] args) {

        //1.构建循环链表
        Node<Integer> first=null;
        Node<Integer> pre=null;
        for(int i=1;i<=41;i++) {
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            if (i == 41) {
                pre.next = first;
            }
        }

            //2.构建count计数器
            int count=0;
            //3.遍历循环链表
            //记录每次遍历拿到的结点，默认从首结点开始
            Node<Integer> n=first;
            //记录当前结点的上一个节点
            Node<Integer> before=null;
            while (n!=n.next){
                //模拟报数
                count++;
                //判断当前报数是不是3
                if(count==3){
                    //如果是3，那么把当前结点删除，重置count
                    before.next=n.next;
                    System.out.println("删除了： "+n.item);
                    count=0;
                    n=n.next;
                }else {//如果不是3，让before变为当前结点
                    before=n;
                    n=n.next;
                }

            }
            System.out.println("最后一个元素： "+n.item);

    }

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
