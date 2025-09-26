package com.codingshuttle.youtube.learningSpringBootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripepay")
public class StripePaymentService implements PaymentService {
    @Override
    public String pay(){
        String payment = "Stripe payment";
        System.out.println("payment from : " + payment);
        return payment;
    }
}
