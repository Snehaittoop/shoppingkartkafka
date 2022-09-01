import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) {
        KafkaProducer producer;
        Properties props=new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"producer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer=new KafkaProducer(props);
        Connection conn=null;
        Statement stmt=null;

            Scanner input=new Scanner(System.in);

            System.out.println("enter the modelname");
            String modelName=input.nextLine();
            System.out.println(modelName);
            System.out.println("enter brand");
            String brand= input.nextLine();
            System.out.println(brand);
            System.out.println("enter releseyear");
            int relese_year= input.nextInt();
            System.out.println(relese_year);
            System.out.println("enter the price");
            int price= input.nextInt();
            System.out.println(price);
            System.out.println("enter the sellername");
            String sellerName= input.nextLine();
            System.out.println(sellerName);
            System.out.println("enter the color");
            String colors= input.nextLine();
            System.out.println(colors);
            System.out.println("enter the date");
            String manufacturingDate= input.next();
            System.out.println(manufacturingDate);

            String sendval=String.format("{'modelname':"+modelName+",'brand':"+brand+",'releseyear':"+relese_year+",'price':"+price+",'sellername':"+sellerName+",'color':"+colors+",'manufacturingDate':"+manufacturingDate+"}");

            producer.send(new ProducerRecord<>("Demonest1",sendval));
            producer.close();

    }
}
