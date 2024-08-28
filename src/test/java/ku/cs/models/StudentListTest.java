package ku.cs.models;

import javafx.css.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    Student s1;
    StudentList list;
    @BeforeEach
    void init(){
        s1 = new Student("6xxxxx","kong",70);
        list = new StudentList();
        list.addNewStudent(s1.getId(),s1.getName(),s1.getScore());
    }
    @Test
    void TestFindStudentById(){
        assertEquals(s1.getName(),list.findStudentById("6xxxxx").getName());

    }
    @Test
    void TestAddNewStudent(){
        list.addNewStudent("333333","Soo");
        assertEquals(s1.getName(),list.findStudentById("6xxxxx").getName());
    }
    @Test
    void TestViewGradeOfId(){
        String grade = list.viewGradeOfId("6xxxxx");
        assertEquals("B",list.viewGradeOfId("6xxxxx"));
    }
    @Test
    void TestGiveScoreToId(){
        list.giveScoreToId("6xxxxx",25);
        assertEquals("A",list.viewGradeOfId("6xxxxx"));
    }
}