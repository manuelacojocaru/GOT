package com.example.got.controller;

import com.example.got.entity.Kingdom;
import com.example.got.service.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class KingdomController {
    private final KingdomService kingdomService;
    @Autowired
    public KingdomController(KingdomService kingdomService) {
        this.kingdomService = kingdomService;
    }
    // add a kingdom
    @PostMapping("/kingdom")
    public Kingdom addKingdom(@RequestBody Kingdom kingdom) {
        return kingdomService.addKingdom(kingdom);
    }

    // get a kingdom
    @GetMapping("/kingdom/{id}")
    public Kingdom getKingdom(@PathVariable Integer id) {
        return kingdomService.getKingdom(id);
    }

    // get all kingdoms
    @GetMapping("/kingdoms")
    public List<Kingdom> getKingdoms() {
        return kingdomService.getKingdoms();
    }
    // update a kingdom
    public Kingdom updateKingdom(@RequestBody Kingdom kingdom) {
        return kingdomService.updateKingdom(kingdom);
    }

    // delete a kindom
    @DeleteMapping("/kingdom/{id}")
    public void deleteKingdom(@PathVariable Integer id) {
        kingdomService.deleteKingdom(id);
    }

    @PostMapping("/kingdom/{kingdomId1}/attack/{kingdomId2}")
    public void attack(@PathVariable Integer kingdomId1, @PathVariable Integer kingdomId2) {
        kingdomService.attack(kingdomId1, kingdomId2);
    }
    // add Person to Kingdom
    @PutMapping("/kingdom/{kingdomId}/addPerson/{personId}")
    public void addPerson(@PathVariable Integer kingdomId, @PathVariable Integer personId) {
        kingdomService.addPerson(kingdomId, personId);
    }

    // set King to Kingdom
    @PutMapping("/kingdom/{kingdomId}/setKing/{personId}")
    public void setKing(@PathVariable Integer kingdomId, @PathVariable Integer personId) {
        kingdomService.setKing(kingdomId, personId);
    }
    // set Queen to Kingdom
    @PutMapping("/kingdom/{kingdomId}/setQueen/{personId}")
    public void setQueen(@PathVariable Integer kingdomId, @PathVariable Integer personId) {
        kingdomService.setQueen(kingdomId, personId);
    }

    // set kingHand
    public void setKingHand(@PathVariable Integer kingdomId, @PathVariable Integer personId) {
        kingdomService.setKingHand(kingdomId, personId);
    }
}
