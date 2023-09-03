package com.codingchallenge.matomogenerator

import org.springframework.stereotype.Service

@Service
class EndpointService(val namespaceRepository: NamespaceRepository, val nameEntryRepository: NameEntryRepository, val validatorService: ValidatorService) {
    fun handleGenerateYaml(nameSpace:String, name:String, host:String ) : NameEntry {

        var namespace = NameSpace(nameSpace)
        namespaceRepository.save(namespace)
        var nameEntry = NameEntry(name, host, namespace)
        var savedEntry = nameEntryRepository.save(nameEntry)
        return savedEntry;
        /*
        if(validatorService.noSuchNamespace(namespaceRepository, nameSpace)){
        }
         */
    }
}