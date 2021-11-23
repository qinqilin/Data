package Sort.Student_Sort;

public class TestComparable {

    public static void main(String[] args) {
        Student s1=new Student(20,"zhangsan");
        Student s2=new Student(25,"lisi");
        Student s3=getMax(s1,s2);
        System.out.println(s3.getAge()+"  "+s3.getUserName());

    }

    public static Student getMax(Student c1,Student c2){

        int result=c1.compareTo(c2);
        if (result>=0){
            return c1;
        }else {
            return c2;
        }
    }
}
