package com.codingchallenge.matomogenerator

import org.springframework.data.jpa.repository.JpaRepository

interface NamespaceRepository : JpaRepository<NameSpace, Long>{

    fun findNameSpaceByNamespaceName(nameSpace:String): NameSpace
}
