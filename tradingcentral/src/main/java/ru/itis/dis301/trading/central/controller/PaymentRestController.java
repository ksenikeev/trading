package ru.itis.dis301.trading.central.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis301.trading.dto.PaymentDto;

@RestController
@RequestMapping("/central/payment")
public class PaymentRestController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto addNewPayment(@RequestBody PaymentDto payment) {
        return payment;
    }
}
