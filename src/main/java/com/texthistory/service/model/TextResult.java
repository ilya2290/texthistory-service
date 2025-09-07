package com.texthistory.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "paragraph_results")
public class TextResult {

    @Id
    private String id;

    private String mostFrequentWord;
    private double avgParagraphSize;
    private double avgParagraphProcessingTime;
    private long totalProcessingTime;

    @Builder.Default
    private Instant processedAt = Instant.now();

}