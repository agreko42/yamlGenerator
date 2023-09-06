package com.codingchallenge.matomogenerator.service

import com.codingchallenge.matomogenerator.ResponseMetadata
import com.codingchallenge.matomogenerator.ResponseSpec
import com.codingchallenge.matomogenerator.ResponseYaml
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    fun buildYamlResponse(nameSpace:String, name:String, host:String) : ResponseEntity<ResponseYaml> {

        val responseHeaders = HttpHeaders()
        //responseHeaders.setLocation(location)
        //responseHeaders.set("MyResponseHeader", "MyValue")
        val responseBody = buildYamlBody(nameSpace, name, host)
        return ResponseEntity(responseBody, responseHeaders, HttpStatus.I_AM_A_TEAPOT)
    }

    fun buildMultiYamlResponse(list : List<ResponseYaml>) : ResponseEntity<List<ResponseYaml>>{
        val responseHeaders = HttpHeaders()
        //responseHeaders.setLocation(location)
        //responseHeaders.set("MyResponseHeader", "MyValue")
        return ResponseEntity(list, responseHeaders, HttpStatus.I_AM_A_TEAPOT)
    }

    fun buildYamlBody(nameSpace:String, name:String, host:String) : ResponseYaml {
        return ResponseYaml(
            "glasskube.eu/v1alpha1",
            "Matomo",
            ResponseMetadata(
                name,
                nameSpace),
            ResponseSpec(host)
        )
    }
}