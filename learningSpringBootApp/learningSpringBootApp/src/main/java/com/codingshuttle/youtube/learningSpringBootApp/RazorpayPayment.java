package com.codingshuttle.youtube.learningSpringBootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component //aab yay hamara bean ban chuka hai.
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorpayPayment implements PaymentService{
    public String pay(){
        String payment = "Razorpay Payment";
        System.out.println("payment from: " + payment);
        return payment;
    }
}
