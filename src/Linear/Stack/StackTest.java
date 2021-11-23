package Linear.Stack;

public class StackTest {
    public static void main(String[] args) {

        Stack<String> stack=new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        for(String i:stack){
            System.out.println(i);
        }
        System.out.println("------------------");
        String re=stack.pop();
        System.out.println("弹出的元素是： "+ re);
        System.out.println("元素个数： "+ stack.size());

    }
}
