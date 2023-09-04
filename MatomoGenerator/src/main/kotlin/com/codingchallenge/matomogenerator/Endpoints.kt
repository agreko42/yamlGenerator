package com.codingchallenge.matomogenerator

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("generator")
class Endpoints (val service: EndpointService) {

    @PostMapping("/")
    fun generateYaml(@RequestBody data : RequestData) {
        println("endpoint says: " + data.nameSpace)
        service.handleGenerateYaml(data.nameSpace, data.name, data.host)
    }
}