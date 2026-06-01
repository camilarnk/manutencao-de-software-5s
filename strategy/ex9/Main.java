public class Main {
    public static void main(String[] args) {

        CalculadoraPontos calculadora = new CalculadoraPontos();
        double valorGasto = 700.0;

        calculadora.setPontuacao(new ClienteComum());
        System.out.printf("Pontos Cliente Comum: %d\n",
                calculadora.calcularPontos(valorGasto));

        calculadora.setPontuacao(new ClientePrata());
        System.out.printf("Pontos Cliente Prata: %d\n",
                calculadora.calcularPontos(valorGasto));

        calculadora.setPontuacao(new ClienteOuro());
        System.out.printf("Pontos Cliente Ouro: %d\n",
                calculadora.calcularPontos(valorGasto));

        calculadora.setPontuacao(new ClienteDiamante());
        System.out.printf("Pontos Cliente Diamante: %d\n",
                calculadora.calcularPontos(valorGasto));
    }
}