public class Main {
    public static void main(String[] args) {

        // o tipo é a interface pois qualquer classe conseguirá implementar
        ITipoFrete frete = new FreteDrone();

        System.out.println(CalculadoraFrete.calculaFrete(5.0, 10, frete));

    }
}