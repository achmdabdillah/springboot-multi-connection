package com.template.demo.service.OracleService;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.demo.dto.PersonDTO;
import com.template.demo.model.OracleModel.Person;
import com.template.demo.repository.OracleRepository.PersonRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void savePerson(PersonDTO person) {
        Person newPerson = new Person();
        newPerson.setName(person.getName());
        newPerson.setAddress(person.getAddress());
        personRepository.save(newPerson);
    }

    @Transactional
    public void updatePerson(Integer id, PersonDTO personDto) throws BadRequestException {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid person id"));

        existingPerson.setName(personDto.getName() == null ? existingPerson.getName() : personDto.getName());
        existingPerson
                .setAddress(personDto.getAddress() == null ? existingPerson.getAddress() : personDto.getAddress());
        personRepository.save(existingPerson);
        return;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Integer id) throws BadRequestException {
        return personRepository.findById(id).orElseThrow(() -> new BadRequestException("Invalid person id"));
    }

    public String deletePerson(Integer id) throws BadRequestException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid person id"));
        personRepository.delete(person);
        return "Person deleted";
    }
}
