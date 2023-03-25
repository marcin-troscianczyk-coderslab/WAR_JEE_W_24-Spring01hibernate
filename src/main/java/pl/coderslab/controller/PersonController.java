package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;

@Controller
@RequiredArgsConstructor
class PersonController {

    private final PersonService personService;

    @GetMapping(path = "/form")
    String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping(path = "/form")
    String processAddForm(Person person) {
        personService.save(person);

        return "success";
    }
}
