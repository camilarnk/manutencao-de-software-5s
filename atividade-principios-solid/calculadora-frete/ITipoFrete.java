// interface necessaria pois ha varios metodos que realizam a açao de calcular,
// porem cada classe reescreve da forma que for preciso

public interface ITipoFrete {
    public double calcularFrete(Double pesoKg, Integer distanciaKm);
}
