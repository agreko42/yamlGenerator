package com.codingchallenge.matomogenerator

import org.springframework.stereotype.Service
import java.io.IOError

@Service
class EndpointService(val namespaceRepository: NamespaceRepository, val nameEntryRepository: NameEntryRepository, val validatorService: ValidatorService) {
    fun handleGenerateYaml(nameSpace:String, name:String, host:String ) : NameEntry? {

        val nameSpaceExists = validatorService.namespaceExists(nameSpace)
        val nameEntryExists = validatorService.nameExists(name, nameSpace)

         if(nameSpaceExists && nameEntryExists){
            throw Throwable("Name already exists in this namespace")
        }
        else if(nameSpaceExists && !nameEntryExists){
            val nSpace = namespaceRepository.findNameSpaceByNamespaceName(nameSpace)
            val nameEntry = nSpace?.let { NameEntry(name, host, it) }
             return nameEntry?.let { nameEntryRepository.save(it) }
        } else{
            val nSpace = NameSpace(nameSpace)
            namespaceRepository.save(nSpace)
            val nameEntry = NameEntry(name, host, nSpace)
            return nameEntryRepository.save(nameEntry)
        }

    }
}