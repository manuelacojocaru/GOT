package com.example.got.service;

import com.example.got.entity.Dragon;
import com.example.got.entity.Person;
import com.example.got.entity.WhiteWalker;
import com.example.got.enums.Weapon;
import com.example.got.repository.DragonRepository;
import com.example.got.repository.PersonRepository;
import com.example.got.repository.WhiteWalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhiteWalkerService {
    private final WhiteWalkerRepository whiteWalkerRepository;
    private final PersonRepository personRepository;
    private final DragonRepository dragonRepository;

    @Autowired
    public WhiteWalkerService(WhiteWalkerRepository whiteWalkerRepository, PersonRepository personRepository, DragonRepository dragonRepository) {
        this.whiteWalkerRepository = whiteWalkerRepository;
        this.personRepository = personRepository;
        this.dragonRepository = dragonRepository;
    }

    public WhiteWalker addWhiteWalker(WhiteWalker whiteWalker) {
        return whiteWalkerRepository.save(whiteWalker);
    }

    public WhiteWalker getWhiteWalker(Integer id) {
        return whiteWalkerRepository.findById(id).orElse(null);
    }

    public List<WhiteWalker> getWhiteWalkers() {
        return whiteWalkerRepository.findAll();
    }

    public WhiteWalker updateWhiteWalker(WhiteWalker whiteWalker) {
        return whiteWalkerRepository.save(whiteWalker);
    }

    public void deleteWhiteWalker(Integer id) {
        whiteWalkerRepository.deleteById(id);
    }

    public void killPerson(Integer whiteWalkerId, Integer personId) {
        WhiteWalker whiteWalker = whiteWalkerRepository.findById(whiteWalkerId).orElse(null);
        Person person = personRepository.findById(personId).orElse(null);
        if (whiteWalker != null && person != null) {
            personRepository.delete(person);
            whiteWalker.oneKill();
        }
    }
    public void killDragon(Integer whiteWalkerId, Integer dragonId) {
        WhiteWalker whiteWalker = whiteWalkerRepository.findById(whiteWalkerId).orElse(null);
        Dragon dragon = dragonRepository.findById(dragonId).orElse(null);
        if (whiteWalker != null && dragon != null) {
            dragonRepository.delete(dragon);
            whiteWalker.oneKill();
        }
    }
    public List<WhiteWalker> getWhiteWalkersWithWeapon(Weapon weapon) {
        return getWhiteWalkers().stream().filter(whiteWalker -> whiteWalker.getWeapon().equals(weapon)).toList();
    }
}
