package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
class StudentController {

    @GetMapping(path = "/student")
    String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping(path = "/student")
    @ResponseBody
    String processForm(Student student) {

        return "Dodano studenta";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
}
