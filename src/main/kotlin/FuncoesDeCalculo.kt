fun calculate(a: Double, b: Double, operation: (Double, Double) -> Double) : Double{
    return operation(a, b)
}

fun soma(a: Double, b: Double) : Double {
    println("executando a soma de $a e $b...")
    return a + b
}

fun subtracao(a: Double, b: Double) : Double {
    println("subtraindo $b de $a...")
    return a - b
}

fun divisao(a: Double, b: Double) : Double {
    println("dividindo $a por $b...")
    return a / b
}

fun multiplicacao(a: Double, b: Double) : Double {
    println("multiplicando $a por $b...")
    return a * b
}