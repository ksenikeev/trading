package ru.itis.dis301.trading.central.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter@Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uid;
    private String name;
    private String nameLat;
    @ManyToOne
    private Country country;

}
