package com.codingchallenge.matomogenerator

import com.codingchallenge.matomogenerator.data.RequestData
import com.codingchallenge.matomogenerator.service.EndpointService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("generator")
class Endpoints (val service: EndpointService) {

    @PostMapping("", produces = ["application/x-yaml"])
    fun generateResource(@RequestBody data : RequestData) : ResponseEntity<ResponseYaml> {
        return service.handleGenerateResource(data.nameSpace, data.name, data.host)
    }

    @GetMapping("/getAll")
    fun getAllResources() : ResponseEntity<List<ResponseYaml>> {
        return service.getAllResources()
    }
}