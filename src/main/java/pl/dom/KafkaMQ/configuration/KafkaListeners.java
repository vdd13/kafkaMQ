package pl.dom.KafkaMQ.configuration;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import pl.dom.KafkaMQ.model.Client;

@Component
public class KafkaListeners {

//	@KafkaListener(topics = "${pl.dom.topicName}",
//			groupId = "yoloGroupID", 
//			containerFactory = "factory"  //factory z kafkaConsumer.class
//					)
//	public void listener1(Client data) {
////		if(data!= null)  // przeniesie event do DLT
////			throw new RuntimeException();
//		
//		System.out.println("Consumer1 data -> " + data.toString());
//	}
	
	
	@RetryableTopic(attempts = "7")
	@KafkaListener(topics = "${pl.dom.topicName}",
			groupId = "yoloGroupID", 
			containerFactory = "factory",  //factory z kafkaConsumer.class 
			topicPartitions =  {@TopicPartition(topic = "${pl.dom.topicName}",
												partitions = {"2"}) })
	public void listener1(Client data) {
//		if(data!= null)  // przeniesie event do DLT
//			throw new RuntimeException();
		
		System.out.println("Consumer1 data -> " + data.toString());
	}

	@DltHandler
	public void listenerDLT(Client data) {
		System.out.println("Consumer DLT data -> " + data.toString());
	}

/** dla @GetMapping  is String **/
	
//	@KafkaListener(topics = {"${pl.dom.topicName}"}, groupId = "yoloGroupID")
//	public void listener1(String data) {
//		System.out.println("Consumer1 data -> " + data);
//	}
//	
//	/*** test partitions **/
//	@KafkaListener(topics = {"${pl.dom.topicName}"}, groupId = "yoloGroupID")
//	public void listener2(String data) {
//		System.out.println("Consumer2 data -> " + data);
//	}
//	
//	@KafkaListener(topics = {"${pl.dom.topicName}"}, groupId = "yoloGroupID")
//	public void listener3(String data) {
//		System.out.println("Consumer3 data -> " + data);
//	}
	
}
