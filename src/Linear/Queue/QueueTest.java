package Linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        for (String i:queue) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        String re=queue.dequeue();
        System.out.println("出队列的元素： "+re);
        System.out.println("-----------------");
        for (String i:queue) {
            System.out.println(i);
        }
        System.out.println(queue.size());
    }
}
