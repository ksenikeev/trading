package ru.itis.dis301.trading.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis301.trading.central.model.MerchCategory;
import ru.itis.dis301.trading.central.model.MerchUnit;

public interface MerchCategoryRepository extends JpaRepository<MerchCategory, Long> {
}
