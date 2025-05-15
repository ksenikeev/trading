package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.Country;
import ru.itis.dis301.trading.central.model.Merch;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findCountryByCode(String code);
}
