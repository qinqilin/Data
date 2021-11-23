package Linear.IsCircle;

import java.io.StringBufferInputStream;

public class GetEntrance {
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

        //链表入口
        Node<String> entrance=getEntrance(first);
        System.out.println(entrance.item);

    }

    private static Node<String> getEntrance(Node<String> first) {
        Node<String> fast=first;
        Node<String> slow=first;
        Node<String> temp=null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){//说明有环
                temp=first;
                continue;
            }
            if(temp!=null){
                temp=temp.next;//让临时结点变化
                if(slow.equals(temp)){
                    break;
                }
            }
        }
        return temp;
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
