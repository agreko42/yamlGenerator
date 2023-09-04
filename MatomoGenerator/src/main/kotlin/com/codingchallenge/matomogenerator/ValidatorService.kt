package com.codingchallenge.matomogenerator

import org.springframework.stereotype.Service

@Service
class ValidatorService (val namespaceRepository: NamespaceRepository, val nameEntryRepository: NameEntryRepository) {

    fun namespaceExists(nameToValidate:String): Boolean {
        println("validating namespace")
        return namespaceRepository.findNameSpaceByNamespaceName(nameToValidate) != null
    }

    fun nameExists(nameToValidate: String, namespaceToValidate: String): Boolean {
        println("validating nameEntry")
        val nameSpace = namespaceRepository.findNameSpaceByNamespaceName(nameToValidate)
        if (nameSpace != null) {
            nameEntryRepository.findNameEntriesByNamespaceAndEntryName(nameSpace, nameToValidate)
        }
        return nameEntryRepository.findNameEntryByEntryName(nameToValidate) != null
    }
}
