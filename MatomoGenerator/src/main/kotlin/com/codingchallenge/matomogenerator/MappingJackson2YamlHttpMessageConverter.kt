package com.codingchallenge.matomogenerator

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter

class MappingJackson2YamlHttpMessageConverter(objectMapper: ObjectMapper)
        : AbstractJackson2HttpMessageConverter(
                objectMapper,
                MediaType.parseMediaType("application/x-yaml")
        ) {
}