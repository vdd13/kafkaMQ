package pl.dom.KafkaMQ.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.dom.KafkaMQ.model.Client;

@RestController
@RequestMapping("prod")
public class KafkaMessageController {

	@Autowired
	KafkaMqService producer;
	
	@GetMapping("/send/{message}")
	public ResponseEntity<String> addMessage(@PathVariable("message") String data){
		try {
			producer.sendMessage(data + " " + Instant.now());
			return ResponseEntity.ok("message added");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/sendjson")
	public ResponseEntity<String> addMessage(@RequestBody Client data){
		try {
			producer.sendJSONMessage(data);
			return ResponseEntity.ok("message added");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
