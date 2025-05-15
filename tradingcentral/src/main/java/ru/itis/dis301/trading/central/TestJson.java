package ru.itis.dis301.trading.central;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis301.trading.central.config.Config;
import ru.itis.dis301.trading.central.model.Offer;
import ru.itis.dis301.trading.central.repository.OfferRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestJson {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        OfferRepository offerRepository = context.getBean(OfferRepository.class);

        Offer offer = new Offer();

        offer.setUid(UUID.randomUUID());

        Map<String, String> properties = new HashMap<>();
        properties.put("Цвет", "Красный");
        properties.put("Год выпуска", "2025");
        offer.setProperties(properties);
        offerRepository.save(offer);

    }
}
