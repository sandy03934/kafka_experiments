package kafka.properties;

import kafka.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ProducerProperties extends Properties {

    public ProducerProperties() {
        load();
    }

    public ProducerProperties(Properties overrides) {
        load();
        overrideWith(overrides);
    }

    private void overrideWith(Properties overrides) {
        putAll(overrides);
    }

    private void load() {
        try {
            load(this.getClass().getClassLoader().getResourceAsStream(Constants.KAFKA_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
    }
}
