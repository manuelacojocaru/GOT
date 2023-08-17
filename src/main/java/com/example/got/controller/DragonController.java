package com.example.got.controller;

import com.example.got.entity.Dragon;
import com.example.got.service.DragonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DragonController {
    private final DragonService dragonService;
    @Autowired
    public DragonController(DragonService dragonService) {
        this.dragonService = dragonService;
    }
    // add a dragon

    @PostMapping("/dragon")
    public Dragon addDragon(@RequestBody Dragon dragon) {
        return dragonService.addDragon(dragon);
    }

    // get a dragon
    @GetMapping("/dragon/{id}")
    public Dragon getDragon(@PathVariable Integer id) {
        return dragonService.getDragon(id);
    }

    // get all dragons
    @GetMapping("/dragons")
    public List<Dragon> getDragons() {
        return dragonService.getDragons();
    }

    // update a dragon
    @PutMapping("/dragon")
    public Dragon updateDragon(@RequestBody Dragon dragon) {
        return dragonService.updateDragon(dragon);
    }

    // delete a dragon
    @DeleteMapping("/dragon/{id}")
    public void deleteDragon(@PathVariable Integer id) {
        dragonService.deleteDragon(id);
    }

    @PostMapping("/dragon/{dragonId}/fire/{personId}")
    public void fire(@PathVariable Integer dragonId, @PathVariable Integer personId) {
        dragonService.fire(dragonId, personId);
    }
}
