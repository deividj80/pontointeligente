package com.reis.pontointeligente.services

import com.reis.pontointeligente.documents.Funcionario
import com.reis.pontointeligente.enums.PerfilEnum
import com.reis.pontointeligente.repositories.FuncionarioRepository
import com.reis.pontointeligente.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val email: String = "deivid@deivid.com"
    private val cpf: String = "00011122233"
    private val id: String = "1"


    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(funcionarios())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())

    }

    @Test
    fun `Persistir funcionario`(){
        val funcionario : Funcionario? = funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun `Buscar por CPF`() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorCpf(cpf)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun `Busca por E-mail`(){
        val funcionario: Funcionario? = funcionarioService?.buscarPorEmail(email)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun `Buscar por Id`(){
        val funcionario: Funcionario? = funcionarioService?.buscarPorId("1")
        Assert.assertNotNull(funcionario)
    }


    private fun funcionario(): Funcionario =
            Funcionario("Nome",
                    email,
                    SenhaUtils().gerarBcrypt("1223344"),
                    cpf,
                    PerfilEnum.ROLE_USUARIO,
                    id)

    private fun funcionarios(): Optional<Funcionario> = Optional.of(funcionario())


}
