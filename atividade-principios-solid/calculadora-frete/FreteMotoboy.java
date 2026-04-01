public class FreteMotoboy implements ITipoFrete {

    @Override
    public double calcularFrete(Double pesoKg, Integer distanciaKm) {

        /* motivos de separar os ifs:
         tratamento de erro diferente
         teste mais simples
         performance (distanciaKm && pesoKg faria 3 testes obrigatoriamente)
         separados, pode haver apenas 1-2 testes */

        if (distanciaKm > 15) {
            System.out.println("Tipo de frete inválido para encomendas que excedem 15km");
            return -1.0;
        }

        if (pesoKg > 10) {
            System.out.println("Tipo de frete inválido para distâncias que excedem 10km");
            return -1.0;
        }

        return 8.00 + (2.00 * distanciaKm);
    }
}
