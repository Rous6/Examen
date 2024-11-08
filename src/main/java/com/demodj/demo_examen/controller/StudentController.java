package com.demodj.demo_examen.controller;

import com.demodj.demo_examen.entity.Student;
import com.demodj.demo_examen.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/lis")
    public String listAllStudents(Model model) {
        model.addAttribute("title", "Lista de Estudiantes");
        model.addAttribute("listaStudent", studentService.getAllStudents());
        return "pages/list-student";
    }

    @GetMapping("/new")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("title", "Agregar Estudiante");
        model.addAttribute("student", student);
        return "pages/form-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/estudiantes/lis";
    }

    @GetMapping("/showUpdateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "pages/form-studentActualizar";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/estudiantes/lis";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/estudiantes/lis";
    }
}

