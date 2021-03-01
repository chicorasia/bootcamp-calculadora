import java.lang.NumberFormatException

fun main(){

    val calculadoraCli = CalculadoraCli()
    calculadoraCli.exibeMenuInicial()

}


class CalculadoraCli {

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
            println("Você selecionou $codigoOperacao.")
            this.processaEntradaNoMenu(codigoOperacao)
        } catch (e: NumberFormatException){
            this.exibeMensagemRetornaMenuInicial()
        }
    }

    internal fun processaEntradaNoMenu(codigoOperacao: Int?) {
        if (codigoOperacao in 1..4) {
            println("Resultado: " + codigoOperacao?.let { executaOperacao(it) })
        } else if (codigoOperacao == 0) {
            println("Saindo. Obrigado por usar a calculadora.")
        } else {
            exibeMensagemRetornaMenuInicial()
        }
    }

    internal fun exibeMensagemRetornaMenuInicial() {
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

    private fun recebeOperando(posicao: String): Int {
        print("Informe o valor do $posicao operando: ")
        return readLine()?.toInt() ?: 0
    }

    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int) : Double{
        return operation(a, b).toDouble()
    }

    fun soma(a: Int, b: Int) : Int {
        println("executando a soma de $a e $b...")
        return a + b
    }

    fun subtracao(a: Int, b: Int) : Int {
        println("subtraindo $b de $a...")
        return a - b
    }

    fun divisao(a: Int, b: Int) : Int {
        println("dividindo $a por $b...")
        return a / b
    }

    fun multiplicacao(a: Int, b: Int) : Int {
        println("multiplicando $a por $b...")
        return a * b
    }



}

