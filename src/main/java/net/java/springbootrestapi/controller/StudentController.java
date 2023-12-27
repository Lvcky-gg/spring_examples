package net.java.springbootrestapi.controller;

import net.java.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {


    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
//        return new ResponseEntity <>(new Student(
//                1,
//                "John",
//                "O'Donnell"
//        ),HttpStatus.OK);
        return ResponseEntity
                .ok()
                .header("custom-header", "john")
                .body(new Student(1, "John", "O'donn"));

    }

    @GetMapping
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "bob", "smith"));
        students.add(new  Student( 1, "Liz", "Marley"));

        return students;
    }
    @GetMapping("/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id, "J", "O");
    }

    @GetMapping("/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "J", "O");
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());

        return student;
    }


    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){

        return "Student deleted";
    }
}
