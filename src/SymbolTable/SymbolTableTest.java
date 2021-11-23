package SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer,String> symbolTable=new SymbolTable<Integer, String>();
        symbolTable.put(1,"a");
        symbolTable.put(2,"b");
        symbolTable.put(3,"c");
        symbolTable.put(4,"d");
        symbolTable.put(1,"zhangsan");
        System.out.println("元素个数： "+symbolTable.size());
        String value=symbolTable.get(1);
        System.out.println("值： "+value);




    }
}
