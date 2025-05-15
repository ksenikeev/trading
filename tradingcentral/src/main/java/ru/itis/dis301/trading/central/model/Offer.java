package ru.itis.dis301.trading.central.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter@Setter
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uid;
    @ManyToOne
    private Organization organization;
    @ManyToOne
    private Merch merch;
    private String description;
    private Float count;
    private Float price;
    @ManyToOne
    private Currency currency;
    private LocalDateTime dateTime;

    @Convert(converter = Json2MapConverter.class)
    @Column(columnDefinition = "text")
    private Map<String, String> properties = new HashMap<>();
}
