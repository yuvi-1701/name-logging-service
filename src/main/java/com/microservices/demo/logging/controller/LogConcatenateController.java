package com.microservices.demo.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class LogConcatenateController {

    @PostMapping("/concatenate-log")
    public ResponseEntity<String> logAndConcatenate(@RequestBody Map<String, String> incomingJsonPayload){

        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId" , traceId);

        log.info("Received request with trace ID: {} and request body: {}", traceId, incomingJsonPayload);

        if (!incomingJsonPayload.containsKey("name") || incomingJsonPayload.get("name") == null || incomingJsonPayload.get("name").isEmpty()) {
            throw new IllegalArgumentException("Invalid JSON: Missing or empty 'name'");
        }
        if (!incomingJsonPayload.containsKey("surname") || incomingJsonPayload.get("surname") == null || incomingJsonPayload.get("surname").isEmpty()) {
            throw new IllegalArgumentException("Invalid JSON: Missing or empty 'surname'");
        }

        String name = incomingJsonPayload.get("name");
        String surname = incomingJsonPayload.get("surname");

        String responseMessage = name + " " + surname;

        log.info("Response for request with traceID : {} : {} ", traceId, responseMessage);

        MDC.clear();

        return ResponseEntity.ok(responseMessage);
    }


}
