package com.example.springsocial.payment;
import com.stripe.model.Plan;

public record  RequestDTO(
    Integer index,
    String customerName,
    String customerEmail

){}

