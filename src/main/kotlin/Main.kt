
import kotlin.math.*
    fun main(args: Array<String>) {
        val larguraGrafico = 100
        val alturaGrafico = 35
        val grafico = Chart(larguraGrafico, alturaGrafico)
        var ciclo = true
        do {
            val alcance = 75.0
            var parede = 25.0
            val x0 = 0.0
            var x = 0.0
            println("Introduza a altura do primeiro atirador (y0=2/y0=4)?")
            val y0 = readLine()!!.toDouble()
            println("Introduza a velocidade Inicial?")
            val velocidadeInicial = readLine()!!.toDouble()
            println("Introduza o ângulo (0-90)?")
            val anguloGraus = readLine()!!.toDouble()
            val anguloRadianos = anguloGraus * PI / 180
            var Voy = velocidadeInicial * sin(anguloRadianos)
            val Vox = velocidadeInicial * cos(anguloRadianos)
            val tg = sin(anguloRadianos) / cos(anguloRadianos)
            var altura = 0.0
            do {
            val y = y0 + tg * x - (5 * (x * x) / (Vox.pow(2)))
                if (y > 0) {
                    grafico.ponto(x, y)
                }
                x++
                if (x == alcance) {
                    while (parede >= 0) {
                        grafico.ponto(x, parede)
                        parede--
                    }
                }
            } while (x < 300)
            grafico.draw()
            println("Quer um novo gráfico (S/N)")
            var continua = readLine()!!.toString()
            ciclo = continua == "S"|| continua == "s"
        } while (ciclo)
    }
