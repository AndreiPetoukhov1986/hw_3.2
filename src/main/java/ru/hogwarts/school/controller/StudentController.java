package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{id}")
    public Student findStudent(@PathVariable("id") long id) {
        return studentService.findStudent(id);
    }

    @PutMapping
    public Student editStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return studentService.editStudent(id, student);

    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable("id") long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> findByAge(@RequestParam(required = false) Integer age) {
        return studentService.findByAge(age);
    }
}
