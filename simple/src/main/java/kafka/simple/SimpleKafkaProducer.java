package kafka.simple;

import kafka.properties.ProducerProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Scanner;

@Slf4j
public class SimpleKafkaProducer {

    private void start() {
        KafkaProducer<String, String> producer = new KafkaProducer<>(new ProducerProperties());
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
            String message = scanner.nextLine();
            ProducerRecord<String, String> kafkaMessage = new ProducerRecord<>("test", message);
            producer.send(kafkaMessage);
            if (message.equalsIgnoreCase("Exit")) {
                flag = false;
            }
        }

    }
    public static void main(String ... args) {
        SimpleKafkaProducer simpleKafkaProducer = new SimpleKafkaProducer();
        simpleKafkaProducer.start();
    }
}
