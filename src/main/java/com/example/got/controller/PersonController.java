package com.example.got.controller;

import com.example.got.entity.Person;
import com.example.got.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    // add a person
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
    // get a person
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return personService.getPerson(id);
    }
    // get all persons
    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }
    // update a person
    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }
    // delete a person
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
    @PostMapping("/person/{personId}/join/{kingdomId}")
    public void join(@PathVariable Integer personId, @PathVariable Integer kingdomId) {
        personService.join(personId, kingdomId);
    }
    // kill a whiteWalker
    @PostMapping("/person/{personId}/killWhiteWalker/{whiteWalkerId}")
    public void killWhiteWalker(@PathVariable Integer personId, @PathVariable Integer whiteWalkerId) {
        personService.killWhiteWalker(personId, whiteWalkerId);
    }
}
