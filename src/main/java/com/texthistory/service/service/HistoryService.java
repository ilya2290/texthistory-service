package com.texthistory.service.service;

import com.texthistory.service.model.TextResult;
import java.util.List;

public interface HistoryService {

    void saveParagraphResults(TextResult textResult);

    List<TextResult> getLast10();
}
