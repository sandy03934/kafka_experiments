package kafka.simple;

import kafka.properties.ConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;

public class SimpleKafkaConsumerWithAssign {

    public static void main(String ... args) {
        SimpleKafkaConsumerWithAssign consumer = new SimpleKafkaConsumerWithAssign();
        consumer.start();
    }

    private void start() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(new ConsumerProperties("test"));

        TopicPartition partition = new TopicPartition("test", 0);
        consumer.assign(Collections.singleton(partition));


//        consumer.subscribe(Collections.singleton("test"));

        boolean flag = true;

        while(flag) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
                if (record.value().equalsIgnoreCase("Exit")) {
                    flag = false;
                }
            }
        }
        consumer.commitAsync();
        consumer.close();
    }
}
