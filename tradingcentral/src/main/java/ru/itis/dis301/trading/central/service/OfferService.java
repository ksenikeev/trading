package ru.itis.dis301.trading.central.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis301.trading.central.model.Merch;
import ru.itis.dis301.trading.central.model.Offer;
import ru.itis.dis301.trading.central.model.Organization;
import ru.itis.dis301.trading.central.repository.*;
import ru.itis.dis301.trading.dto.OfferDto;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private MerchRepository merchRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private MerchUnitRepository merchUnitRepository;

    @Autowired
    private MerchCategoryRepository merchCategoryRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Transactional
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer offerAdapter(OfferDto offerDto) {
        Offer offer =
                offerRepository.findOfferByUid(offerDto.getUid())
                                .orElse(new Offer());

        offer.setUid(offerDto.getUid());

        Organization organization =
                organizationRepository.findOrganizationByUid(offerDto.getOrganization().getUid())
                            .orElse(new Organization());

        organization.setUid(offerDto.getUid());
        organization.setName(offerDto.getOrganization().getName());
        organization.setNameLat(offerDto.getOrganization().getNameLat());
        organization.setCountry(
                countryRepository.findCountryByCode(offerDto.getOrganization().getCountry())
                        .orElseThrow(() -> new EntityNotFoundException()));

        offer.setOrganization(organization);

        Merch merch =
                merchRepository.findMerchByUid(offerDto.getMerch().getUid())
                        .orElse(new Merch());

        merch.setUid(offerDto.getMerch().getUid());
        merch.setName(offerDto.getMerch().getName());
        merch.setMerchUnit(merchUnitRepository.findById(offerDto.getMerch().getUnit())
                .orElseThrow(() -> new EntityNotFoundException()));
        merch.setCategory(merchCategoryRepository
                .findById(offerDto.getMerch().getCategoty())
                .orElseThrow(() -> new EntityNotFoundException()));

        offer.setMerch(merch);

        offer.setCount(offerDto.getCount());
        offer.setCurrency(currencyRepository
                .findCurrencyByCode(offerDto.getCurrency())
                .orElseThrow(() -> new EntityNotFoundException()));

        offer.setPrice(offerDto.getPrice());
        offer.setDateTime(offerDto.getDateTime());

        Map<String, String> properties =
                offer.getProperties() != null ?
                        offer.getProperties() : new HashMap<>();

        for (var entry : offerDto.getProperties().entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        offer.setProperties(properties);

        return offer;
    }

}
