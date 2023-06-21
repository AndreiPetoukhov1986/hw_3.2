package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long count = 0;

    public Student addStudent(Student student) {
        student.setId(count++);
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        } else {
            throw new StudentNotFoundException(id);
        }
    }

    public Student editStudent(Long id, Student student) {
        if (students.containsKey(id)) {
            Student oldStudent = students.get(id);
            oldStudent.setName(student.getName());
            oldStudent.setAge(student.getAge());
            students.replace(id, oldStudent);
            return oldStudent;
        } else {
            throw new StudentNotFoundException(id);
        }
    }


    public Student deleteStudent(long id) {
        if (students.containsKey(id)) {
            return students.remove(id);
        } else {
            throw new StudentNotFoundException(id);
        }
    }

    public List<Student> findByAge(Integer age) {
        return Optional.ofNullable(age)
                .map(a->
                        students.values().stream()
                                .filter(faculty -> faculty.getAge()==a)
                )
                .orElseGet(()->students.values().stream())
                .collect(Collectors.toList());
    }
}
