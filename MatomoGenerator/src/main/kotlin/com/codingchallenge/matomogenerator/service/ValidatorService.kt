package com.codingchallenge.matomogenerator.service

import com.codingchallenge.matomogenerator.data.NameEntryRepository
import com.codingchallenge.matomogenerator.data.NamespaceRepository
import org.springframework.stereotype.Service

@Service
class ValidatorService (val namespaceRepository: NamespaceRepository, val nameEntryRepository: NameEntryRepository) {

    fun namespaceExists(nameToValidate:String): Boolean {
        println("validating namespace")
        return namespaceRepository.findNameSpaceByNamespaceName(nameToValidate) != null
    }

    fun nameExistsInNamespace(nameToValidate: String, namespaceToValidate: String): Boolean {
        println("validating nameEntry")
        val nameSpace = namespaceRepository.findNameSpaceByNamespaceName(namespaceToValidate)
        return nameSpace?.let { nameEntryRepository.findNameEntryByEntryNameAndNamespace(nameToValidate, it) } != null
    }
}
