enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val aluno: Usuario,
    val nivel: List<Nivel>,
    val inscritos: MutableList<Usuario> = mutableListOf(),
) {
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    
    val usuario1 = Usuario("Paola", 30, "paola@email.com")
    val usuario2 = Usuario("André", 26,  "andre@email.com")
    val usuario3 = Usuario("Venilton", 34, "venilton@email.com")
    
    val conteudo1 = ConteudoEducacional("Trabalhando em Equipes Ágeis", 180, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Tratamento de Exceções em Kotlin", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Arquitetura Orientada a Eventos com Java, SpringBoot e Kafka", 180, Nivel.AVANCADO)
    
    val formacao1 = Formacao(
        "Princípios de Desenvolvimento Ágil e Colaborativo",
        listOf(conteudo1),
        usuario1,
        listOf(Nivel.BASICO)
    )
    
    val formacao2 = Formacao(
        "Desmistificando Kotlin para Programadores Java",
        listOf(conteudo2, conteudo3),
        usuario3,
        listOf(Nivel.INTERMEDIARIO)
    )
    
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario1)
    formacao2.matricular(usuario3)

    println("Alunos matriculados em Princípios de Desenvolvimento Ágil e Colaborativo:")
    formacao1.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Idade: ${aluno.idade}, E-mail: ${aluno.email}")
        
    }
    
    println("Alunos matriculados em Desmistificando Kotlin para Programadores Java:")
    formacao2.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Idade: ${aluno.idade}, E-mail: ${aluno.email}")
        
    }
    
}