import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/2/24 10:48
 * @since 1.0.0
 */

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(123L);
        Student clone = (Student)student.clone();
        Student st = student;


        List<Student> students = Collections.singletonList(student);
        List<Student> students1 = Collections.singletonList(student);
        Integer[] ints = of(1,2,3,4,5);
        Integer[] copys = Arrays.copyOf(ints, ints.length);
        copys[0] = 98;
        System.out.println(ints[0]);
        Integer[] clone1 = ints.clone();
        clone1[0] = 99;
        System.out.println(ints[0]);
        System.out.println(clone1 == ints);

        System.out.println(students == students1);


        Student[] students2 = of(1L, 2L, 3L);
        Student[] stuCopy = Arrays.copyOf(students2, students2.length);
        stuCopy[0].setId(99L);
        for (int i = 0; i < students2.length; i++) {
            System.out.println(students2[i]);

        }


    }

    private static Integer[] of(Integer... values) {
        return values;
    }

    private static Student[] of(Long... ids){
        Student[] students = new Student[ids.length];
        for (int i = 0; i < ids.length; i++) {
            students[i] = new Student(ids[i]);
        }

        return students;
    }

}


class Student implements Cloneable{


    private Long id;

    public Student( Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
