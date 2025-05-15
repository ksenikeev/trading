package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.Merch;
import ru.itis.dis301.trading.central.model.Organization;

import java.util.Optional;
import java.util.UUID;

public interface MerchRepository extends JpaRepository<Merch, Long> {
    Optional<Merch> findMerchByUid(UUID uid);
}
