package com.reis.pontointeligente.repositories

import com.reis.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository


interface EmpresaRepository : MongoRepository<Empresa,String>{
    fun findByCnpj(cnpj: String): Empresa
}