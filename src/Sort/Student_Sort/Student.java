package Sort.Student_Sort;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private int age;
    private String userName;

    public Student() {
    }
    public Student(int age, String userName) {
        this.age = age;
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + age +
                ", userName='" + userName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(userName, student.userName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(age, userName);
    }
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }

}
