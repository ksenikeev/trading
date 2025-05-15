package ru.itis.dis301.trading.central.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter@Setter
public class Merch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uid;
    @ManyToOne
    private MerchCategory category;
    private String name;
    @ManyToOne
    private MerchUnit merchUnit;
}
