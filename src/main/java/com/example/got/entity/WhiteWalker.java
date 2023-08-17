package com.example.got.entity;

import com.example.got.enums.Weapon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
public class WhiteWalker {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer height;
    private Integer power;
    private Integer victims;
    @Enumerated(EnumType.STRING)
    private Weapon weapon;
    private Boolean isKing;

    public WhiteWalker() {
        victims = 0;
        isKing = false;
    }

    public void oneKill() {
        victims++;
    }
}
