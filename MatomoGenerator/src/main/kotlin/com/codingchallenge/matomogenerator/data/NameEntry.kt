package com.codingchallenge.matomogenerator.data

import jakarta.persistence.*

@Entity
 data class NameEntry(
    val entryName : String,
    val host : String,

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn
        var namespace : NameSpace,

    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long = 0
         ) {

 }
