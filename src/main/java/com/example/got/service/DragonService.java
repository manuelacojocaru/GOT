package com.example.got.service;

import com.example.got.entity.Dragon;
import com.example.got.entity.Person;
import com.example.got.repository.DragonRepository;
import com.example.got.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DragonService {
    private final DragonRepository dragonRepository;
    private final PersonRepository personRepository;
    @Autowired
    public DragonService(DragonRepository dragonRepository, PersonRepository personRepository) {
        this.dragonRepository = dragonRepository;
        this.personRepository = personRepository;
    }
    public Dragon addDragon(Dragon dragon) {
        return dragonRepository.save(dragon);
    }
    public Dragon getDragon(Integer id) {
        return dragonRepository.findById(id).orElse(null);
    }
    public List<Dragon> getDragons() {
        return dragonRepository.findAll();
    }
    public Dragon updateDragon(Dragon dragon) {
        return dragonRepository.save(dragon);
    }
    public void deleteDragon(Integer id) {
        dragonRepository.deleteById(id);
    }
    public void fire(Integer dragonId, Integer personId) {
        Dragon dragon = dragonRepository.findById(dragonId).orElse(null);
        Person person = personRepository.findById(personId).orElse(null);
        if(dragon != null && person != null) {
            personRepository.delete(person);
        }
    }
}
