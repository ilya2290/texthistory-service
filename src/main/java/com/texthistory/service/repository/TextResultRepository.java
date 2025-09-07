package com.texthistory.service.repository;

import com.texthistory.service.model.TextResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TextResultRepository extends MongoRepository<TextResult, String> {

    List<TextResult> findTop10ByOrderByProcessedAtDesc();
}
