package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.dto.FacultyDtoOut;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyDtoOut addFaculty(@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.addFaculty(facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut findFaculty(@PathVariable("id") Long id) {
        return facultyService.findFaculty(id);
    }

    @PutMapping
    public FacultyDtoOut editFaculty(@PathVariable("id") Long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.editFaculty(id, facultyDtoIn);
    }

    @DeleteMapping("{id}")
    public FacultyDtoOut deleteFaculty(@PathVariable("id") Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public List<FacultyDtoOut> findByColor(@RequestParam(required = false) String color) {
        return facultyService.findByColor(color);
    }
}
