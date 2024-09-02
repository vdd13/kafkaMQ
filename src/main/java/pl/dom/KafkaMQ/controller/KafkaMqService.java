package pl.dom.KafkaMQ.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.SmartMessageConverter;
import org.springframework.stereotype.Service;

import pl.dom.KafkaMQ.model.Client;


@Service
public class KafkaMqService {

	@Value("${pl.dom.topicName}")
	private String topicName;
	
	public KafkaTemplate<String, Object> kafkaTemplate;
	
	public KafkaMqService(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
//		kafkaTemplate.setMessagingConverter((SmartMessageConverter) new MappingJackson2MessageConverter());
	}

	public void sendMessage(String msg){
		CompletableFuture<SendResult<String, Object>> future =  kafkaTemplate.send(topicName, msg);
		future.whenComplete((result, exception) -> {
			if(exception == null) {
				System.out.println("message: " + msg + ", offset: " + result.getRecordMetadata().offset());
			}else {
				System.out.println("error " + exception);
			}
		});
	}
	
	public void sendJSONMessage(Client data){
		try {
//			CompletableFuture<SendResult<String, Object>> future =  kafkaTemplate.send(topicName, data); // bez numeru partycji kolejki
			CompletableFuture<SendResult<String, Object>> future =  kafkaTemplate.send(topicName,2, null, data); //z partition
			future.whenComplete((result, exception) -> {
				if(exception == null) {
					System.out.println("message: " + data + ", offset: " + result.getRecordMetadata().offset());
				}else {
					System.out.println("error " + exception);
				}
			});
		} catch(Exception e) {
			System.out.println("ERROR !! " + e.getMessage());
		}
	}
}
