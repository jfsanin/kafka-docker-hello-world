package com.jsanin;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {

    private static final String BROKER_URL = "localhost:9092";
    private static final String TOPIC_NAME = "testing";
    private static final String CONSUMER_GROUP = "consumer-testing";
    private static final Duration TIMEOUT = Duration.ofSeconds(1);

    public static void main(String[] args) {
        Properties consumerConfig = new Properties();
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP);

        try(final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerConfig)){
            consumer.subscribe(Collections.singletonList(TOPIC_NAME));
            while(true){
                ConsumerRecords<String, String> newMessages = consumer.poll(TIMEOUT);
                newMessages.forEach(record -> System.out.println("value: " + record.value()));
            }
        }
    }
}
