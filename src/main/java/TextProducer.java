import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class TextProducer {

    public static void main(String[] args) {
//        Step 1: configure producer properties
        Properties props = new Properties();

        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

//        Step 2: Create producer instance
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

//        Step 3: Create producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic340", "Here we go There and here" );
//        Step 4: Send data
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
