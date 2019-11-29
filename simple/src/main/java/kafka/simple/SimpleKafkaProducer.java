package kafka.simple;

import kafka.properties.ProducerProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class SimpleKafkaProducer {

    private void start() throws ExecutionException, InterruptedException {
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
            producer.flush();
        }

    }
    public static void main(String ... args) throws ExecutionException, InterruptedException {
        SimpleKafkaProducer simpleKafkaProducer = new SimpleKafkaProducer();
        simpleKafkaProducer.start();
    }
}
