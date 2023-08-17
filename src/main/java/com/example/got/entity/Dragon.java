package com.example.got.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dragon {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String color;
    @OneToOne(mappedBy = "dragon", cascade = CascadeType.ALL)
    private Person owner;
}