package com.tf.inventory.service.kafka.producers;

import com.tf.events.inventories.BrandCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public InventoryProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BrandCreatedEvent brandCreatedEvent){
        LOGGER.info(String.format("Brand added =>%s",brandCreatedEvent.toString()));

        Message<BrandCreatedEvent> message = MessageBuilder.withPayload(brandCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC,"inventory-brand-created")
                .build();

        kafkaTemplate.send(message);

    }

}
