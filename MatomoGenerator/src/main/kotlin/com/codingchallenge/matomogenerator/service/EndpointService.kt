package com.codingchallenge.matomogenerator.service

import com.codingchallenge.matomogenerator.data.NameEntry
import com.codingchallenge.matomogenerator.data.NameEntryRepository
import com.codingchallenge.matomogenerator.data.NameSpace
import com.codingchallenge.matomogenerator.data.NamespaceRepository
import org.springframework.stereotype.Service

@Service
class EndpointService(val namespaceRepository: NamespaceRepository, val nameEntryRepository: NameEntryRepository, val validatorService: ValidatorService, val responseBuilder: ResponseBuilderService) {
    fun handleGenerateResource(nameSpace:String, name:String, host:String ) : String? {

        val nameSpaceExists = validatorService.namespaceExists(nameSpace)
        val nameEntryExists = validatorService.nameExistsInNamespace(name, nameSpace)

         if(nameSpaceExists && nameEntryExists){
             val nSpace = namespaceRepository.findNameSpaceByNamespaceName(nameSpace)
             val nEntry = nSpace?.let { nameEntryRepository.findNameEntryByEntryNameAndNamespace(name, it) }
             return nEntry?.let{responseBuilder.buildResponseString(
                 it.namespace.namespaceName,
                 it.entryName,
                 it.host)}
        }
        else if(nameSpaceExists){
            val nSpace = namespaceRepository.findNameSpaceByNamespaceName(nameSpace)
            val nameEntry = nSpace?.let { NameEntry(name, host, it) }
            val savedEntry = nameEntry?.let { nameEntryRepository.save(it) }
            return savedEntry?.let {responseBuilder
             .buildResponseString(
                 it.namespace.namespaceName,
                 it.entryName,
                 it.host
                 )}
        }
         else {
            val nSpace = NameSpace(nameSpace)
            namespaceRepository.save(nSpace)
            val nameEntry = NameEntry(name, host, nSpace)
            val savedEntry = nameEntryRepository.save(nameEntry)
            return responseBuilder
             .buildResponseString(
                 savedEntry.namespace.namespaceName,
                 savedEntry.entryName,
                 savedEntry.host)
        }

    }

    fun getAllResources() : List<String> {
        return nameEntryRepository
            .findAll()
            .stream()
            .map { entry -> responseBuilder
                .buildResponseString(
                    entry.namespace.namespaceName,
                    entry.entryName,
                    entry.host)}
            .toList()
    }
}