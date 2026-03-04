public class FreteCorreios implements ITipoFrete {

    @Override
    public double calcularFrete(Double pesoKg, Integer distanciaKm) {

        if (pesoKg > 30) {
            System.out.println("Tipo de frete inválido para encomendas que excedem 30kg");
            return -1.0; // retornando erro caso o peso exceda o limite da modalidade
        }

        return 12.00 + (1.50 * pesoKg) + (0.05 * distanciaKm);
    }
}
