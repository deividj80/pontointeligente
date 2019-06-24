package com.reis.pontointeligente

import com.reis.pontointeligente.documents.Empresa
import com.reis.pontointeligente.documents.Funcionario
import com.reis.pontointeligente.enums.PerfilEnum
import com.reis.pontointeligente.repositories.EmpresaRepository
import com.reis.pontointeligente.repositories.FuncionarioRepository
import com.reis.pontointeligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PontointeligenteApplication(val empresaRepository: EmpresaRepository, val funcionarioRepository: FuncionarioRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {

        empresaRepository.deleteAll()
        funcionarioRepository.deleteAll()

        var empresa: Empresa = empresaRepository.save(Empresa("Deivid Corp", "00447217000144"))

        val admin : Funcionario = funcionarioRepository.save(Funcionario("Admin",
                "admin@admin.com",
                SenhaUtils().gerarBcrypt("123456"),
                "39034726037",
                PerfilEnum.ROLE_ADMIN,
                empresa.id!!))

        val funcionario : Funcionario = funcionarioRepository.save(Funcionario("Admin",
                "fun@admin.com",
                SenhaUtils().gerarBcrypt("123456"),
                "27370210065",
                PerfilEnum.ROLE_ADMIN,
                empresa.id!!))

        println("Empresa ID: " + empresa.id)
        println("Admin ID: " + admin.id)
        println("Funcionario ID: " + funcionario.id)

    }

}

fun main(args: Array<String>) {
    SpringApplication.run(PontointeligenteApplication::class.java, *args)
}