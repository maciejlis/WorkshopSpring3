package com.skni.workshopspring3.Service;

import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.skni.workshopspring3.Entity.Student;
import com.skni.workshopspring3.Repository.StudentRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> findAllByLastName(String lastName){
        return studentRepository.findAllByLastName(lastName);
    }
    public Student addStudent(String firstName, String lastName, LocalDate date, GenderEnum gender, Course course){
    Student student = Student.builder().firstName(firstName).lastName(lastName).date(date).gender(gender).course(course).build();
    studentRepository.save(student);
    return student;
    }
    public Student getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum type){
        return studentRepository.getStudentByGenderAndCourse_CourseType(gender,type);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public String deleteStudentById(Integer id){
        studentRepository.deleteById(id);
        return "Student o id "+id;
    }
    public List<Student> findStudentWhereFirstNameStartsWithA(){
        return studentRepository.findStudentWhereFirstNameStartsWithA();
    }
}
