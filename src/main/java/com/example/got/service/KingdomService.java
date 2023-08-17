package com.example.got.service;

import com.example.got.entity.Kingdom;
import com.example.got.entity.Person;
import com.example.got.repository.KingdomRepository;
import com.example.got.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Service
public class KingdomService {
    private final KingdomRepository kingdomRepository;
    private final PersonRepository personRepository;
    @Autowired
    public KingdomService(KingdomRepository kingdomRepository, PersonRepository personRepository) {
        this.kingdomRepository = kingdomRepository;
        this.personRepository = personRepository;
    }
    public Kingdom addKingdom(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }
    public Kingdom getKingdom(Integer id) {
        return kingdomRepository.findById(id).orElse(null);
    }
    public List<Kingdom> getKingdoms() {
        return kingdomRepository.findAll();
    }
    public Kingdom updateKingdom(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }
    public void deleteKingdom(Integer id) {
        kingdomRepository.deleteById(id);
    }

    public void attack(Integer kingdomId1, Integer kingdomId2) {
        Kingdom kingdom1 = kingdomRepository.findById(kingdomId1).orElse(null);
        Kingdom kingdom2 = kingdomRepository.findById(kingdomId2).orElse(null);
        if(kingdom1 != null && kingdom2 != null && !kingdomId1.equals(kingdomId2)) {
            Random random = new Random();
            int kingdom1Power = random.nextInt();
            int kingdom2Power = random.nextInt();
            if(kingdom1Power > kingdom2Power) {
                kingdomRepository.delete(kingdom2);
            } else {
                kingdomRepository.delete(kingdom1);
            }
        }
    }
    // add Person to Kingdom
    public void addPerson(Integer kingdomId, Integer personId) {
        Kingdom kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if(kingdom != null) {
            Person person = personRepository.findById(personId).orElse(null);
            if(person != null) {
                kingdom.addPerson(person);
                person.setKingdom(kingdom);
                kingdomRepository.save(kingdom);
            }
        }
    }

    // set King to Kingdom
    public void setKing(Integer kingdomId, Integer personId) {
        Kingdom kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if(kingdom != null) {
            Person person = personRepository.findById(personId).orElse(null);
            if(person != null) {
                kingdom.setKing(person);
                person.setKingdomAsKing(kingdom);
                kingdomRepository.save(kingdom);
            }
        }
    }

    // set Queen to Kingdom
    public void setQueen(Integer kingdomId, Integer personId) {
        Kingdom kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if(kingdom != null) {
            Person person = personRepository.findById(personId).orElse(null);
            if(person != null) {
                kingdom.setQueen(person);
                person.setKingdomAsQueen(kingdom);
                kingdomRepository.save(kingdom);
            }
        }
    }

    // set kingHand
    public void setKingHand(Integer kingdomId, Integer personId) {
        Kingdom kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if(kingdom != null) {
            Person person = personRepository.findById(personId).orElse(null);
            if(person != null) {
                kingdom.setKingHand(person);
                person.setKingdomAsHand(kingdom);
                personRepository.save(person);
                kingdomRepository.save(kingdom);
            }
        }
    }
}
