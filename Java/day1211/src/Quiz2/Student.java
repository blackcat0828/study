package Quiz2;

import java.util.Objects;

public class Student {
    private String studentName;

    public Student(String studentName){
        this.studentName=studentName;
    }

    public String getStudentName(){
        return studentName;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student s = (Student)o;
            return s.studentName==((Student) o).studentName;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentName.hashCode();
    }
}
