package com.codingchallenge.matomogenerator

import org.springframework.data.jpa.repository.JpaRepository

interface NameEntryRepository : JpaRepository<NameEntry, Long> {
    fun findNameEntryByEntryName(entry: String) : NameEntry?
    fun findNameEntriesByNamespaceAndEntryName(namespace: NameSpace, entryName:String)
}