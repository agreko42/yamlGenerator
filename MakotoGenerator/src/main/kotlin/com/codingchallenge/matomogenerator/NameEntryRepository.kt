package com.codingchallenge.matomogenerator

import org.springframework.data.jpa.repository.JpaRepository

interface NameEntryRepository : JpaRepository<NameEntry, Long> {
    fun findNameEntryByEntryName(entry: String);
}