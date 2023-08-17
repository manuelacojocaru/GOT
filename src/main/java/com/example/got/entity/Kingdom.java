package com.example.got.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kingdom {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "king_id")
    private Person king;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "queen_id")
    private Person queen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kinghand_id")
    private Person kingHand;
    @OneToMany(mappedBy = "kingdom", cascade = CascadeType.ALL)
    private List<Person> army = new ArrayList<>();

    public void addPerson(Person person) {
        army.add(person);
    }

    public void setKing(Person person) {
        king = person;
    }

    public void setQueen(Person person) {
        queen = person;
    }

    public void setKingHand(Person person) {
        kingHand = person;
    }
}