public class FreteDrone implements ITipoFrete {

    @Override
    public double calcularFrete(Double pesoKg, Integer distanciaKm) {
        if (distanciaKm > 30) {
            System.out.println("Tipo de frete inválido para encomendas que excedem 30km");
            return -1.0;
        }

        if (pesoKg > 10) {
            System.out.println("Tipo de frete inválido para distâncias que excedem 10km");
            return -1.0;
        }

        return 30.00 + (5.00 * distanciaKm);
    }
}
