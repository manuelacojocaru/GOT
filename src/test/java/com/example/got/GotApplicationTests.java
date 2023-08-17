package com.example.got;

import com.example.got.entity.Dragon;
import com.example.got.entity.Kingdom;
import com.example.got.entity.Person;
import com.example.got.entity.WhiteWalker;
import com.example.got.repository.DragonRepository;
import com.example.got.repository.KingdomRepository;
import com.example.got.repository.PersonRepository;
import com.example.got.repository.WhiteWalkerRepository;
import com.example.got.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GotApplicationTests {
    @Autowired
    private DragonService dragonService;
    @Autowired
    private DragonRepository dragonRepository;
    @Autowired
    private KingdomService kingdomService;
    @Autowired
    private KingdomRepository kingdomRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private WhiteWalkerService whiteWalkerService;
	@Autowired
    private WhiteWalkerRepository whiteWalkerRepository;
    @Autowired
    private PoemService poemService;

    @Test
    void addDragonTest() {
        int before = dragonService.getDragons().size();
        Dragon dragon = new Dragon();
        dragonService.addDragon(dragon);
        int after = dragonService.getDragons().size();
        Assertions.assertEquals(before + 1, after);
        dragonRepository.delete(dragon);
    }

    @Test
    void addKingdomTest() {
        int before = kingdomService.getKingdoms().size();
        Kingdom kingdom = new Kingdom();
        kingdomService.addKingdom(kingdom);
        int after = kingdomService.getKingdoms().size();
        Assertions.assertEquals(before + 1, after);
        kingdomRepository.delete(kingdom);
    }
    @Test
    void addPersonTest() {
        int before = personService.getPersons().size();
        Person person = new Person();
        personService.addPerson(person);
        int after = personService.getPersons().size();
        Assertions.assertEquals(before + 1, after);
        personRepository.delete(person);
    }
    @Test
    void addWhiteWalkerTest() {
        int before = whiteWalkerService.getWhiteWalkers().size();
        WhiteWalker whiteWalker = new WhiteWalker();
        whiteWalkerService.addWhiteWalker(whiteWalker);
        int after = whiteWalkerService.getWhiteWalkers().size();
        Assertions.assertEquals(before + 1, after);
        whiteWalkerRepository.delete(whiteWalker);
    }
    @Test
    void poemTest() {
        String poem = poemService.getPoem("John Snow");
        Assertions.assertNotNull(poem);
    }
    @Test
    void dragonFireTest() {
        Dragon dragon = new Dragon();
        dragonService.addDragon(dragon);
        Person person = new Person();
        personService.addPerson(person);
        int before = personService.getPersons().size();
        dragonService.fire(dragon.getId(), person.getId());
        int after = personService.getPersons().size();
        Assertions.assertEquals(before - 1, after);
        dragonRepository.delete(dragon);
        personRepository.delete(person);
    }

    @Test
    void kingdomAttackTest() {
        Kingdom kingdom1 = new Kingdom();
        kingdomService.addKingdom(kingdom1);
        Kingdom kingdom2 = new Kingdom();
        kingdomService.addKingdom(kingdom2);
        int before = kingdomService.getKingdoms().size();
        kingdomService.attack(kingdom1.getId(), kingdom2.getId());
        int after = kingdomService.getKingdoms().size();
        Assertions.assertEquals(before - 1, after);
        kingdomRepository.delete(kingdom1);
        kingdomRepository.delete(kingdom2);
    }

    @Test
    void killWhiteWalkerTest() {
        WhiteWalker whiteWalker = new WhiteWalker();
        whiteWalkerService.addWhiteWalker(whiteWalker);
        Person person = new Person();
        personService.addPerson(person);
        int before = whiteWalkerService.getWhiteWalkers().size();
        personService.killWhiteWalker(person.getId(), whiteWalker.getId());
        int after = whiteWalkerService.getWhiteWalkers().size();
        Assertions.assertEquals(before - 1, after);
        whiteWalkerRepository.delete(whiteWalker);
        personRepository.delete(person);
    }

    @Test
    void killPersonTest() {
        WhiteWalker whiteWalker = new WhiteWalker();
        whiteWalkerService.addWhiteWalker(whiteWalker);
        Person person = new Person();
        personService.addPerson(person);
        int before = personService.getPersons().size();
        whiteWalkerService.killPerson(whiteWalker.getId(), person.getId());
        int after = personService.getPersons().size();
        Assertions.assertEquals(before - 1, after);
        whiteWalkerRepository.delete(whiteWalker);
        personRepository.delete(person);
    }

    @Test
    void killDragonTest() {
        WhiteWalker whiteWalker = new WhiteWalker();
        whiteWalkerService.addWhiteWalker(whiteWalker);
        Dragon dragon = new Dragon();
        dragonService.addDragon(dragon);
        int before = dragonService.getDragons().size();
        whiteWalkerService.killDragon(whiteWalker.getId(), dragon.getId());
        int after = dragonService.getDragons().size();
        Assertions.assertEquals(before - 1, after);
        whiteWalkerRepository.delete(whiteWalker);
        dragonRepository.delete(dragon);
    }
}
