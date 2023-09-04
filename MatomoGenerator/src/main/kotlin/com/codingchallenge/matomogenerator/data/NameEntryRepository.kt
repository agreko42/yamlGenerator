package com.codingchallenge.matomogenerator.data

import com.codingchallenge.matomogenerator.data.NameEntry
import com.codingchallenge.matomogenerator.data.NameSpace
import org.springframework.data.jpa.repository.JpaRepository

interface NameEntryRepository : JpaRepository<NameEntry, Long> {
    fun findNameEntryByEntryName(entry: String) : NameEntry?
    fun findNameEntryByEntryNameAndNamespace( entryName:String, namespace: NameSpace) : NameEntry?
}