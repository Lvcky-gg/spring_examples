package net.java.springbootrestapi.controller;

import net.java.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        return new ResponseEntity <>(new Student(
                1,
                "John",
                "O'Donnell"
        ),HttpStatus.OK);

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "bob", "smith"));
        students.add(new  Student( 1, "Liz", "Marley"));

        return students;
    }
    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id, "J", "O");
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "J", "O");
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());

        return student;
    }


    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){

        return "Student deleted";
    }
}
