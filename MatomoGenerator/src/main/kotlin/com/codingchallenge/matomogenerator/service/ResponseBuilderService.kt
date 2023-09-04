package com.codingchallenge.matomogenerator.service

import org.springframework.stereotype.Service

@Service
class ResponseBuilderService {
    fun buildResponseString(nameSpace:String, name:String, host:String) : String{
       return """
        yaml
        apiVersion: "glasskube.eu/v1alpha1"
        kind: Matomo
        metadata:
          name: $name
          namespace: $nameSpace
        spec:
          host: $host
        """.trimIndent()
    }
}