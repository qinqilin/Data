package Linear.ReversePolishNottation;

import Linear.Stack.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*","18", "6","/","+"};
        int result=caculate(notation);
        System.out.println("逆波兰表达式的结果为： "+result);
    }

    private static int caculate(String[] notation) {
        //1.定义一个栈，存储操作数
        Stack<Integer> str=new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notation.length; i++) {
            String curr=notation[i];
            //3.判断当前元素是否是操作数
            Integer o1;
            Integer o2;
            switch (curr){
               //4.如果是运算符，则从栈中弹出2个元素，完成运算的结果再压入栈中
                case "+":
                    o1=str.pop();
                    o2=str.pop();
                    str.push(o2+o1);
                    break;
                case "-":
                    o1=str.pop();
                    o2=str.pop();
                    str.push(o2-o1);
                    break;
                case "*":
                    o1=str.pop();
                    o2=str.pop();
                    str.push(o2*o1);
                    break;
                case "/":
                    o1=str.pop();
                    o2=str.pop();
                    str.push(o2/o1);
                    break;
                default:
                    //5.将操作数压入栈中
                    str.push(Integer.valueOf(curr));
                    break;
            }
        }
        //6.得到栈中的最后一个元素，就是逆波兰表达式的结果
        return str.pop();
    }

}
