import java.lang.NumberFormatException
import kotlin.system.exitProcess

class CalculadoraConsole {

    val mapOperacoes: Map<Int, String> = mapOf(
        1 to "Soma",
        2 to "Subtração",
        3 to "Divisão",
        4 to "Multiplicação",
        0 to "Sair"
    )

    fun exibeMenuInicial() {
        println(
            """
        +-----------------------+
        + C A L C U L A D O R A +
        +-----------------------+
        + Escolha uma operação  +
        + [1] Soma              +
        + [2] Subtração         +
        + [3] Divisão           +
        + [4] Multiplicacão     +
        + [0] Sair              +
        +-----------------------+
        """.trimIndent()
        )

        print("Digite uma opção: ")

        try{
            val codigoOperacao = readLine()?.toInt()
            println("Você selecionou $codigoOperacao: ${mapOperacoes[codigoOperacao]}.")
            this.processaEntradaNoMenu(codigoOperacao)
        } catch (e: NumberFormatException){
            this.exibeMensagemRetornaMenuInicial()
        }
    }

    fun processaEntradaNoMenu(codigoOperacao: Int?) {
        if (codigoOperacao in 1..4) {
            println("Resultado: " + codigoOperacao?.let { executaOperacao(it) })
        } else if (codigoOperacao == 0) {
            exibeMensagemSaida()
            exitProcess(0)
        } else {
            exibeMensagemRetornaMenuInicial()
        }
    }

    fun exibeMensagemSaida() {
        println("Saindo. Obrigado por usar a calculadora.")
    }

    fun exibeMensagemRetornaMenuInicial() {
        println("Escolha um número entre 1 e 4 ou digite 0 para sair.")
        exibeMenuInicial()
    }

    fun executaOperacao(operacao: Int) : Double {

        val a = recebeOperando("primeiro")
        val b = recebeOperando("segundo")

        return when(operacao){
            1 -> calculate(a, b,::soma)
            2 -> calculate(a, b,::subtracao)
            3 -> calculate(a, b,::divisao)
            4 -> calculate(a, b,::multiplicacao)
            else -> -1.0
        }

    }

    private fun recebeOperando(posicao: String): Double {
        print("Informe o valor do $posicao operando: ")
        return (readLine()?.toDouble() ?: 0) as Double
    }

    fun exibeMensagemNovaOperacao() : Boolean {
        println("Deseja executar mais uma operação? [S] [N]: ")
        val resposta: Char = readLine()?.first() ?: 'n'
        return resposta.toUpperCase() == 'S'
    }

}