package pl.dom.KafkaMQ.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

	@Value("${pl.dom.topicName}")
	private String topicName;
	
//	@Bean
//	public NewTopic mojTopic() {
//		return TopicBuilder
//				.name(topicName)
//				.partitions(3)
//				.build();
//	}
}
