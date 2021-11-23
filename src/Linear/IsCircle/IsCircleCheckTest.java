package Linear.IsCircle;

import Linear.FastSlow.FastSlowTest;

public class IsCircleCheckTest {
    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next=third;

        //判断链表是否有环
        boolean isCircle=isCircleCheck(first);
        System.out.println(isCircle);

    }

    private static boolean isCircleCheck(Node<String> first) {
        Node<String> fast=first;
        Node<String> slow=first;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
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
