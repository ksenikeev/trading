package ru.itis.dis301.trading.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter@Setter@ToString
public class OfferDto {
    private UUID uid;
    private OrganizationDto organization;
    private MerchDto merch;
    private String description;
    private Float count;
    private Float price;
    private String currency;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dateTime;
    private Map<String, String> properties;
}
/**
 * test data
 * {"uid":"14e33c47-aafb-472a-9a08-44f5aff5a489",
 * organization}
 */