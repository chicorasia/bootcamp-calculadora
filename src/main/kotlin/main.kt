import java.lang.NumberFormatException

fun main(){

    var novaOperacao = true
    val calculadoraConsole = CalculadoraConsole()

    while(novaOperacao){
        calculadoraConsole.exibeMenuInicial()
        novaOperacao = calculadoraConsole.exibeMensagemNovaOperacao()
    }
    calculadoraConsole.exibeMensagemSaida()

}



