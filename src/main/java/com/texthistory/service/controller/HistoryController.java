package com.texthistory.service.controller;

import com.texthistory.service.constants.Endpoints;
import com.texthistory.service.model.TextResult;
import com.texthistory.service.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = Endpoints.BETVICTOR_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TextResult>> getHistory() {
        return ResponseEntity.ok(historyService.getLast10());
    }
}
