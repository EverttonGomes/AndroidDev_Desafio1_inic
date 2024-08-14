fun calcularPegadaCarbono(tipoEnergia: String, consumo: Double): Double? {

    val fatorEmissaoEletricidade = 0.475
    val fatorEmissaoGasNatural = 2.0

    return when (tipoEnergia.lowercase()) {
        "eletricidade" -> consumo * fatorEmissaoEletricidade
        "gás natural" -> consumo * fatorEmissaoGasNatural
        else -> {
            println("Tipo de energia inválido!")
            null
        }
    }
}

fun main() {
    var totalPegadaCarbono = 0.0

    while (true) {
        print("Digite o tipo de energia (eletricidade ou gás natural) ou 'sair' para encerrar: ")
        val tipoEnergia = readLine()?.trim() ?: ""

        if (tipoEnergia.lowercase() == "sair") {
            break
        }

        print("Digite o consumo de $tipoEnergia: ")
        val consumo = readLine()?.toDoubleOrNull()

        if (consumo != null) {
            val pegadaCarbono = calcularPegadaCarbono(tipoEnergia, consumo)
            if (pegadaCarbono != null) {
                totalPegadaCarbono += pegadaCarbono
                println("Pegada de carbono para $tipoEnergia: $pegadaCarbono kg CO₂")
            }
        } else {
            println("Consumo inválido!")
        }
    }

    println("Pegada de carbono total: $totalPegadaCarbono kg CO₂")
}
