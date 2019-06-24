package com.reis.pontointeligente.services.impl

import com.reis.pontointeligente.documents.Empresa
import com.reis.pontointeligente.repositories.EmpresaRepository
import com.reis.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)


}