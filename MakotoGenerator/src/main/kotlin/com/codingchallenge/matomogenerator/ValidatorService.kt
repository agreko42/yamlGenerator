package com.codingchallenge.matomogenerator

import org.springframework.stereotype.Service

@Service
class ValidatorService {

    fun noSuchNamespace(namespaceRepository: NamespaceRepository, nameToValidate:String): Boolean {
        println("name to validate: $nameToValidate")
        println(namespaceRepository.findNameSpaceByNamespaceName(nameToValidate)==null)
        return namespaceRepository.findNameSpaceByNamespaceName(nameToValidate).equals(null)
    }

    fun noSuchName(nameEntryRepository: NameEntryRepository, nameToValidate: String): Boolean {
        return !nameEntryRepository.findNameEntryByEntryName(nameToValidate).equals(null)
    }
}
