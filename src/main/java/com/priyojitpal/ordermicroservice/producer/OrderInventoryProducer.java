package com.priyojitpal.ordermicroservice.producer;

import com.priyojitpal.ordermicroservice.entities.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderInventoryProducer {
    @Value("${kafka.topic}")
    private String kafkaTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderInventoryProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTestMessage() {
        kafkaTemplate.send(kafkaTopic, "This is test Message!!");
    }

    public void inventoryUpdate(Order order) {
        kafkaTemplate.send(kafkaTopic, order.getInventoryId());
    }
}
