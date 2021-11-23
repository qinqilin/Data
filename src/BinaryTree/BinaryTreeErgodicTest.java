package BinaryTree;

import Linear.Queue.Queue;

public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String,String> bt=new BinaryTree<String, String>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");

        //前序遍历
        //Queue<String> queue= bt.preErgodic();
        //中序遍历
        //Queue<String> queue= bt.midErgodic();
        //后序遍历
        //Queue<String> queue= bt.afterErgodic();
        //层序遍历
        Queue<String> queue= bt.layerErgodic();
        for(String key:queue){
            System.out.print(key);
        }


    }
}
