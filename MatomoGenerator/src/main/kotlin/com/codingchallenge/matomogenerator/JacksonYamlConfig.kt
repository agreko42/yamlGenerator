package com.codingchallenge.matomogenerator

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JacksonYamlConfig {
    @Bean
    fun yamlHttpMessageConverter(): MappingJackson2YamlHttpMessageConverter {
        val mapper = YAMLMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        return MappingJackson2YamlHttpMessageConverter(mapper)
    }
}