package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.Country;
import ru.itis.dis301.trading.central.model.MerchUnit;

import java.util.Optional;

public interface MerchUnitRepository extends JpaRepository<MerchUnit, Long> {
}
