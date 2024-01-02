package com.example.springsocial.controller;
import com.example.springsocial.payment.PlanDAO;
import com.example.springsocial.payment.RequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerListParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class PaymentController {

    @Value("${stripe.secretKey}")
    private String STRIPE_API_KEY;



    @PostMapping("/checkout/hosted")
    String hostedCheckout(@RequestBody RequestDTO requestDTO) throws StripeException, JsonProcessingException {
        Stripe.apiKey = STRIPE_API_KEY;
        String clientBaseURL = "http://localhost:5173";

        // Start by finding an existing customer record from Stripe or creating a new one if needed
        Customer customer = findOrCreateCustomer(requestDTO.customerEmail(), requestDTO.customerName());

        // Define the prices for your subscription plans
        String monthlyPriceId = "price_1OSLgpLjRm5KgpNdR3dOT5wA"; // replace with your actual price ID for the monthly plan
        String yearlyPriceId = "price_1OSLcuLjRm5KgpNdxKhiJoxS"; // replace with your actual price ID for the yearly plan

        // Choose the price ID based on the index in the request
        String priceId = requestDTO.index() == 1 ? monthlyPriceId : yearlyPriceId;

        // Next, create a checkout session by adding the details of the checkout
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setCustomer(customer.getId())
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setPrice(priceId)
                        .setQuantity(1L)
                        .build())
                .setSuccessUrl(clientBaseURL + "/success?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(clientBaseURL + "/failure")
                .build();

        Session session = Session.create(params);

//        return session.getUrl();
        // Create a map to hold the response data
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("url", session.getUrl());

// Convert the map to a JSON string
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(responseData);

        return jsonResponse;

    }




    public static Customer findOrCreateCustomer(String email, String name) throws StripeException {
        Stripe.apiKey = "sk_test_51OS0YSLjRm5KgpNdyF9LnTQ2OmittinKQt4DP9MfFrIFK4gBvuW2TY4COSgCOuIEaGL5D8s7XWzfCvKTk3kP57zf00KDibU1RU"; // replace with your actual Stripe secret key


        CustomerListParams params = CustomerListParams.builder()
                .setEmail(email)
                .build();

        CustomerCollection customers = Customer.list(params);

        if (!customers.getData().isEmpty()) {
// If a customer with the provided email was found, return it
            return customers.getData().get(0);
        } else {
            // If no customer was found, create a new one
            CustomerCreateParams createParams = CustomerCreateParams.builder()
                    .setEmail(email)
                    .setName(name)
                    .build();
            return Customer.create(createParams);
        }
    }
}