package com.codingchallenge.matomogenerator

import jakarta.persistence.*

@Entity
data class NameSpace(var namespaceName: String, ) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0

    @OneToMany(mappedBy = "namespace", fetch = FetchType.LAZY)
    var nameEntries = mutableListOf<NameEntry>()


}
