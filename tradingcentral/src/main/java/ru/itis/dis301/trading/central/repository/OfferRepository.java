package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.Offer;
import java.util.Optional;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferByUid(UUID uid);

}
