package com.cockroachlabs.field.paymentsdemo.PaymentsProcessorMockup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.text.RandomStringGenerator;

import java.time.Instant;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CardTransactionController {

    private final long sleepMs;

    private final WeightedStatus[] statuses = new WeightedStatus[] {
            new WeightedStatus("APP", .7),
            new WeightedStatus("DEC", .2),
            new WeightedStatus("ERR", .1),
    };

    CardTransactionController(@Value("${payments_demo.processor.sleepMs}") long sleepMs) {
        this.sleepMs = sleepMs;
    }

    @PostMapping("/transactions")
    EntityModel<CardTransaction> newCardTransaction(@RequestBody CardTransaction newCardTransaction) throws InterruptedException {

        //TODO: add validation of the incoming transaaction (amount, card number, etc.)

        // Choose a random status based on weightings (70% ACCEPTED, 20% DECLINED, 10% ERROR)
        double totalWeight = 1.0;
        int randomIndex = -1;
        double random = Math.random() * totalWeight;
        for (int i = 0; i < statuses.length; ++i)
        {
            random -= statuses[i].getWeight();
            if (random <= 0.0d)
            {
                randomIndex = i;
                break;
            }
        }
        WeightedStatus myRandomStatus = statuses[randomIndex];
        String statusCode = myRandomStatus.getStatus();
        newCardTransaction.setStatus(statusCode);

        //if the transaction is approved, generate an authorization code
        if (statusCode.equals("APP")) {
            RandomStringGenerator generator = new RandomStringGenerator.Builder()
                    .withinRange('A', 'Z').build();

            newCardTransaction.setAuthorizationCode(generator.generate(6));
        }

        newCardTransaction.setTransactionDate(Instant.now());

        //sleep a configurable amount of time to impersonate the network latency from calling a remote service
        Thread.sleep(sleepMs);

        System.out.println("Processing POST request for transactions - transaction ID: " + newCardTransaction.getTransactionId() + " at " + Instant.now().toString());

        return EntityModel.of(newCardTransaction,
                linkTo(methodOn(CardTransactionController.class).newCardTransaction(newCardTransaction)).withSelfRel()
        );
    }
}
