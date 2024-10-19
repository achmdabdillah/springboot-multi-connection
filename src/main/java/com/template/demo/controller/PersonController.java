package com.template.demo.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.demo.dto.PersonDTO;
import com.template.demo.model.OracleModel.Person;
import com.template.demo.service.OracleService.PersonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() throws Exception {
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersons(@PathVariable Integer id) throws Exception {
        return personService.getPersonById(id);
    }

    @PostMapping("/person")
    public String insertPerson(@RequestBody PersonDTO personDto) {
        log.info("Person: {}", personDto);
        personService.savePerson(personDto);
        return "Person saved";
    }

    @PostMapping("/person/{id}")
    public String updatePerson(@PathVariable Integer id, @RequestBody PersonDTO personDto)
            throws BadRequestException {
        personService.updatePerson(id, personDto);
        return "Person updated";
    }

    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable Integer id) throws BadRequestException {
        return personService.deletePerson(id);
    }
}
