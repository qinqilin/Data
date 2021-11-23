package Sort.ShellAandInsertCompare;

import Sort.Insert_Sort.Insert_M2;
import Sort.Shell_Sort.Shell_M2;

import java.io.*;
import java.util.ArrayList;

public class SortCompare {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\BaiduNetdiskDownload\\资料-2020版数据结构与算法\\数据结构与算法资料\\代码\\algorithm\\src\\reverse_arr.txt")));
        String line=null;
        while ((line= reader.readLine())!=null){
            int i=Integer.parseInt(line);
            list.add(i);
        }
        reader.close();
        Integer[] a=new Integer[list.size()];
        list.toArray(a);

        //testInsert(a);
        testShell(a);

    }


    //测试希尔
    public static void testShell(Integer[] a){
        long start=System.currentTimeMillis();
        Shell_M2.sort(a);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    //测试插入
    public static void testInsert(Integer[] a){
        long start=System.currentTimeMillis();
        Insert_M2.sort(a);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
}
