package com.texthistory.service.service.impl;

import com.texthistory.service.model.TextResult;
import com.texthistory.service.repository.TextResultRepository;
import com.texthistory.service.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final TextResultRepository repository;

    @Override
    public void saveParagraphResults(TextResult textResult) {
        repository.save(textResult);
    }

    @Override
    public List<TextResult> getLast10() {
        return repository.findTop10ByOrderByProcessedAtDesc();
    }
}
