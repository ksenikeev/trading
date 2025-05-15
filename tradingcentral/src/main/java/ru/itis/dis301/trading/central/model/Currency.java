package ru.itis.dis301.trading.central.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Currency extends AbstractDictionary {
    @ManyToOne
    private Country country;
}
