package kafka.properties;

import kafka.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class ConsumerProperties extends Properties {

    public ConsumerProperties(String groupId) {
        Objects.requireNonNull(groupId, "GroupId Mandatory");
        load(groupId);
    }

    public ConsumerProperties(Properties overrides) {
        Objects.requireNonNull(overrides, "Can't pass a null overrides");
        Objects.requireNonNull(overrides.getProperty(ConsumerConfig.GROUP_ID_CONFIG), "GroupId Mandatory");
        load(overrides.getProperty(ConsumerConfig.GROUP_ID_CONFIG));
        override(overrides);
    }

    private void override(Properties overrides) {
        putAll(overrides);
    }

    private void load(String groupId) {
        try {
            load(this.getClass().getClassLoader().getResourceAsStream(Constants.KAFKA_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());
        put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());
    }
}
