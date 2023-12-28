package com.example.springsocial.payment;

import com.stripe.model.Price;
import com.stripe.model.Plan;

import java.math.BigDecimal;

public class PlanDAO {

    static Plan[] Plans;

/*
    static {
        Plans = new Plan[4];

        Plan samplePlan = new Plan();
        Price samplePrice = new Price();

        samplePlan.setId("shoe");
        samplePrice.setCurrency("usd");
        samplePrice.setUnitAmountDecimal(BigDecimal.valueOf(2000));
        samplePlan.setDefaultPriceObject(samplePrice);
        Plans[0] = samplePlan;

        samplePlan = new Plan();
        samplePrice = new Price();

        samplePlan.setName("Nike Sliders");
        samplePlan.setId("slippers");
        samplePrice.setCurrency("usd");
        samplePrice.setUnitAmountDecimal(BigDecimal.valueOf(1000));
        samplePlan.setDefaultPriceObject(samplePrice);
        Plans[1] = samplePlan;

        samplePlan = new Plan();
        samplePrice = new Price();

        samplePlan.setName("Apple Music+");
        samplePlan.setId("music");
        samplePrice.setCurrency("usd");
        samplePrice.setUnitAmountDecimal(BigDecimal.valueOf(499));
        samplePlan.setDefaultPriceObject(samplePrice);
        Plans[2] = samplePlan;

    }
*/

    public static Plan getPlan(String id) {

        if ("shoe".equals(id)) {
            return Plans[0];
        } else if ("slippers".equals(id)) {
            return Plans[1];
        } else if ("music".equals(id)) {
            return Plans[2];
        } else return new Plan();

    }
}
