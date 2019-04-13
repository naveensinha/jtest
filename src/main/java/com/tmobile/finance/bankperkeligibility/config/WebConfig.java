package com.tmobile.finance.bankperkeligibility.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

//@Configuration
public class WebConfig extends WebMvcConfigurationSupport
{
   /* @Value("${resttemplate.connection.timeout:10000}")
    private int connectionTimeOut;

    @Value("${resttemplate.read.timeout:10000}")
    private int readTimeOut;

    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate  template = new RestTemplate();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(connectionTimeOut);
        factory.setReadTimeout(readTimeOut);
        template.setRequestFactory(factory);
        return template;
    }


    @Bean
    public ObjectMapper configureObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new ISO8601DateFormat());
        return objectMapper;
    }*/
}
