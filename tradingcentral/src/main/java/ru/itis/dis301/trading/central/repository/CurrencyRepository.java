package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.Country;
import ru.itis.dis301.trading.central.model.Currency;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByCode(String code);
}
