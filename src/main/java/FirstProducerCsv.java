import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class FirstProducerCsv {

    public static void main(String[] args) throws FileNotFoundException {
//      Step 1:  Setting Producer configuration properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

//        Step 2: Setting up Kafka instance
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

//       Step 3: Reading data from csv
        //parsing a CSV file into Scanner class constructor
        Scanner scan = new Scanner(new File("C:\\Users\\use\\OneDrive\\Desktop\\3_error.log.txt"));
        scan.useDelimiter(",");   //sets the delimiter pattern
        while (scan.hasNext())  //returns a boolean value
        {
            // Step 4: Creating producer Record
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic342", scan.next());

            // Step 5: Sending/ Publishing data to Kafka cluster
            producer.send(record);
            producer.flush();

            //find and returns the next complete token from this scanner
            System.out.print(scan.next());

        }
        //closes the scanner
        scan.close();
//        Close the producer
        producer.close();
    }
    }

