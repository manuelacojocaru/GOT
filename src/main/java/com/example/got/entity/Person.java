package com.example.got.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer height;
    private Integer power;
    @OneToOne(mappedBy = "king", cascade = CascadeType.ALL)
    private Kingdom kingdomAsKing;
    @OneToOne(mappedBy = "queen", cascade = CascadeType.ALL)
    private Kingdom kingdomAsQueen;
    @OneToOne(mappedBy = "kingHand", cascade = CascadeType.ALL)
    private Kingdom kingdomAsHand;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dragon_id")
    private Dragon dragon;
    @ManyToOne
    @JoinColumn(name = "kingdom_id")
    private Kingdom kingdom;

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }
}