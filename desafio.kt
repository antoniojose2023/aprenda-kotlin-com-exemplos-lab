// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    //cursos individuais
    val moduloJava = ConteudoEducacional("curso java", 120)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 60)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    
    //formação completa com todos os cursos
    val formacaoAndroid = Formacao("Formação Android Developer", listConteudos, Nivel.INTERMEDIARIO)
    
    //Criar lista de usuarios
    val jose = Usuario("jose", "jose@gmail.com")
    val maria = Usuario("maria", "maria@gmail.com")
    
    //matriculando usuarios na formação
    formacaoAndroid.matricular(jose)
    formacaoAndroid.matricular(maria)
    
    println("======================================")
    println("Dados da formação")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Grade formação")
    println(formacaoAndroid.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoAndroid.imprimirListaInscritos())
