public class FreteTransportadora implements ITipoFrete {

    @Override
    public double calcularFrete(Double pesoKg, Integer distanciaKm) {

        double frete = 20.00 + (1.00 * pesoKg) + (0.03 * distanciaKm);

        if (pesoKg > 50) {
            frete *= 0.9;
        }

        return frete;
    }
}
