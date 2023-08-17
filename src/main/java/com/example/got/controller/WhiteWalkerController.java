package com.example.got.controller;

import com.example.got.entity.WhiteWalker;
import com.example.got.enums.Weapon;
import com.example.got.service.WhiteWalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WhiteWalkerController {
    private final WhiteWalkerService whiteWalkerService;
    @Autowired
    public WhiteWalkerController(WhiteWalkerService whiteWalkerService) {
        this.whiteWalkerService = whiteWalkerService;
    }
    // add a whiteWalker
    @PostMapping("/whiteWalker")
    public WhiteWalker addWhiteWalker(@RequestBody WhiteWalker whiteWalker) {
        return whiteWalkerService.addWhiteWalker(whiteWalker);
    }
    // get a whiteWalker
    @GetMapping("/whiteWalker/{id}")
    public WhiteWalker getWhiteWalker(@PathVariable Integer id) {
        return whiteWalkerService.getWhiteWalker(id);
    }
    // get all whiteWalkers
    @GetMapping("/whiteWalkers")
    public List<WhiteWalker> getWhiteWalkers() {
        return whiteWalkerService.getWhiteWalkers();
    }
    // update a whiteWalker
    @PutMapping("/whiteWalker")
    public WhiteWalker updateWhiteWalker(@RequestBody WhiteWalker whiteWalker) {
        return whiteWalkerService.updateWhiteWalker(whiteWalker);
    }
    // delete a whiteWalker
    @DeleteMapping("/whiteWalker/{id}")
    public void deleteWhiteWalker(@PathVariable Integer id) {
        whiteWalkerService.deleteWhiteWalker(id);
    }
    @PostMapping("/whiteWalker/{whiteWalkerId}/killPerson/{personId}")
    public void killPerson(@PathVariable Integer whiteWalkerId, @PathVariable Integer personId) {
        whiteWalkerService.killPerson(whiteWalkerId, personId);
    }
    //  kill Dragon
    @PostMapping("/whiteWalker/{whiteWalkerId}/killDragon/{dragonId}")
    public void killDragon(@PathVariable Integer whiteWalkerId, @PathVariable Integer dragonId) {
        whiteWalkerService.killDragon(whiteWalkerId, dragonId);
    }
    // get all whiteWalkers with a weapon
    @GetMapping("/whiteWalkers/weapon/{weapon}")
    public List<WhiteWalker> getWhiteWalkersWithWeapon(@PathVariable Weapon weapon) {
        return whiteWalkerService.getWhiteWalkersWithWeapon(weapon);
    }
}
