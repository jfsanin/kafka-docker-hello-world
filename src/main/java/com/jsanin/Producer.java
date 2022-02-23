package com.jsanin;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {

    static final String BROKER_URL = "localhost:9092";
    static final String TOPIC_NAME = "testing";
    static final int TIME_TO_SLEEP_FOR_NEXT_MESSAGE_IN_MILlIS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Properties producerConfig = new Properties();
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        int messageCount = 0;
        try(KafkaProducer<String, String> producer = new KafkaProducer<>(producerConfig)){
            while(true) {
                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "key", "value" + messageCount);
                producer.send(record);
                messageCount++;
                Thread.sleep(TIME_TO_SLEEP_FOR_NEXT_MESSAGE_IN_MILlIS);
            }
        }
    }
}
