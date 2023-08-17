package com.example.got.service;

import com.example.got.entity.Kingdom;
import com.example.got.entity.Person;
import com.example.got.entity.WhiteWalker;
import com.example.got.repository.KingdomRepository;
import com.example.got.repository.PersonRepository;
import com.example.got.repository.WhiteWalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final KingdomRepository kingdomRepository;
    private final WhiteWalkerRepository whiteWalkerRepository;
    @Autowired
    public PersonService(PersonRepository personRepository, KingdomRepository kingdomRepository, WhiteWalkerRepository whiteWalkerRepository ) {
        this.personRepository = personRepository;
        this.kingdomRepository = kingdomRepository;
        this.whiteWalkerRepository = whiteWalkerRepository;
    }
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElse(null);
    }
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
    public void join(Integer personId, Integer kingdomId) {
        Person person = personRepository.findById(personId).orElse(null);
        Kingdom kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if(person != null && kingdom != null) {
            person.setKingdom(kingdom);
            personRepository.save(person);
        }
    }
    public void killWhiteWalker(Integer personId, Integer whiteWalkerId) {
        Person person = personRepository.findById(personId).orElse(null);
        WhiteWalker whiteWalker = whiteWalkerRepository.findById(whiteWalkerId).orElse(null);
        if (person != null && whiteWalker != null) {
            if(whiteWalker.getIsKing()) {
                whiteWalkerRepository.deleteAll();
            }
            else {
                whiteWalkerRepository.delete(whiteWalker);
            }
        }
    }
}
