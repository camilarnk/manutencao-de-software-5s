// regras de negocio da venda devem ser implementadas aqui
// a interface + tipos de frete implementam as regras de cada modalidade

public class CalculadoraFrete {

    public static Double calculaFrete(Double pesokg, Integer distanciaKm, ITipoFrete frete) {
        return frete.calcularFrete(pesokg, distanciaKm); // independente do tipo, a linha sera executada
    }

}
