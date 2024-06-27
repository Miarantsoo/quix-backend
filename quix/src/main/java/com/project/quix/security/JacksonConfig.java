package com.project.quix.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        StreamWriteConstraints constraints = StreamWriteConstraints.builder()
                .maxNestingDepth(3000)
                .build();
        objectMapper.getFactory().setStreamWriteConstraints(constraints);
        return objectMapper;
    }
}