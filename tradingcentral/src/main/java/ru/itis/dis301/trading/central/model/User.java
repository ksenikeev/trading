package ru.itis.dis301.trading.central.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder
public class User {
    private String username;
    private String password;
    private String role;
}
