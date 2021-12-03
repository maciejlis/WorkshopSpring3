package com.skni.workshopspring3.Repository;

import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.skni.workshopspring3.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByLastName(String lastName);
    Student getStudentByGenderAndCourse_CourseType(GenderEnum gender, CourseTypeEnum type);
    //Wybiera studentów i kursy gdzie imie studenta zaczyna się na "A"
    @Query(value = "Select * FROM Student s JOIN Course c on s.course_id=c.course_id where s.first_name like 'A%'",nativeQuery = true)
    List<Student> findStudentWhereFirstNameStartsWithA();
}
