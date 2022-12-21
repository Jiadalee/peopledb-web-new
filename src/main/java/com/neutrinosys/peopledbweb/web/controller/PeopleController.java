package com.neutrinosys.peopledbweb.web.controller;


import com.neutrinosys.peopledbweb.biz.model.Person;
import com.neutrinosys.peopledbweb.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @GetMapping
//    public String getPeople(Model model){
//        List<Person> people = List.of(
//            new Person(10l, "Jake", "Snake", LocalDate.of(1950, 1, 1), "dummy@sample.com",new BigDecimal("50000")),
//            new Person(20l, "Sarah", "Snake", LocalDate.of(1960, 1, 1), "dummy@sample.com",new BigDecimal("40000")),
//            new Person(30l, "Johny", "Snake", LocalDate.of(1970, 1, 1), "dummy@sample.com",new BigDecimal("30000")),
//            new Person(40l, "Bobby", "Snake", LocalDate.of(1980, 1, 1), "dummy@sample.com",new BigDecimal("20000")),
//            new Person(50l, "Mathew", "Snake", LocalDate.of(1990, 1, 1), "dummy@sample.com",new BigDecimal("10000"))
//        );
//        model.addAttribute("people", people);
//        return "people";
//    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
         return personRepository.findAll();
    }

    @ModelAttribute
    public Person person(){
        Person person = new Person();
        person.setFirstName("Joker");
        return person;
    }

    @GetMapping
    public String showPeoplePage(){
        return "people";
    }

}
