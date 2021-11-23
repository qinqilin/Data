package Linear.BracketsMatch;

import Linear.Stack.Stack;

public class BracketsMatchTest {

    public static void main(String[] args) {
        String str="(上海(长安)())";
        boolean match=isMatch(str);
        System.out.println("字符串中的括号是否匹配： "+match);
    }

    private static boolean isMatch(String str) {
        //1.创建栈对象，存储左括号
        Stack<String> chars=new Stack<>();
        //2.从左往右遍历字符串
        for(int i=0;i<str.length();i++){
            String currChar=str.charAt(i)+"";
            //3.判断当前字符是否为左括号，如果是，就把左括号放入栈中
            if(currChar.equals("(")){
                chars.push(currChar);
            }
            //4.继续判断当前字符是否是右括号，如果是，就从栈中弹出一个左括号并判断弹出的结果是否为null,
            //如果为null,证明没有匹配的左括号
            if(currChar.equals(")")){
                String isnull=chars.pop();
                if(isnull==null){
                    return false;
                }
            }
        }
        //5.判断栈中还有没有剩余的元素，如果有那么不匹配
        if(chars.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

}
