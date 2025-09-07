package com.texthistory.service.consumer;

import com.texthistory.service.model.TextResult;
import com.texthistory.service.service.HistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TextResultConsumer {
    private final HistoryService historyService;
    private final ObjectMapper objectMapper;

    @KafkaListener(
        topics = "${app.kafka-topic}",
        groupId = "${spring.kafka.consumer.group-id}",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(String message) {
        log.info("Consumed: {} | Thread: {}", message, Thread.currentThread().getName());

        try {
            TextResult textResult = this.objectMapper.readValue(message, TextResult.class);
            this.historyService.saveParagraphResults(textResult);

            log.info("Saved to Mongo: {}", textResult.getMostFrequentWord());
        } catch (Exception e) {
            log.error("Error processing message: {}", message, e);
        }
    }
}
