package com.codingchallenge.matomogenerator.data

import com.codingchallenge.matomogenerator.data.NameSpace
import org.springframework.data.jpa.repository.JpaRepository

interface NamespaceRepository : JpaRepository<NameSpace, Long>{

    fun findNameSpaceByNamespaceName(nameSpace:String): NameSpace?
}
